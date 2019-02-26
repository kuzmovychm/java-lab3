package ua.lviv.iot.models;

import java.util.LinkedList;
import java.util.List;

public class GameRoom {

    private double playgroundArea;
    private AgeGroup ageGroup;
    private double moneyAvailable;
    private int presentChildren;
    private List<Toy> toys = new LinkedList<>();
    private List<Child> children = new LinkedList<>();

    public GameRoom(double playgroundArea,
                    AgeGroup ageGroup,
                    double moneyAvailable) {

        this.playgroundArea = playgroundArea;
        this.ageGroup = ageGroup;
        this.moneyAvailable = moneyAvailable;

    }

    public GameRoom(double playgroundArea,
                    AgeGroup ageGroup,
                    double moneyAvailable,
                    List<Toy> toys,
                    List<Child> children) {

        this(playgroundArea, ageGroup, moneyAvailable);
        this.toys = toys;
        this.children = children;

    }

    public double getPlaygroundArea() {
        return playgroundArea;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public double getMoneyAvailable() {
        return moneyAvailable;
    }

    public int getPresentChildren() {
        return presentChildren;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "GameRoom{"
                + "playgroundArea=" + playgroundArea
                + ", ageGroup=" + ageGroup
                + ", moneyAvailable=" + moneyAvailable
                + ", presentChildren=" + presentChildren
                + ", toys=" + toys
                + ", children=" + children
                + '}';
    }

    public int calculateMaximalNumberOfChildren() {
        return (int) (playgroundArea / 4);
    }

    public int calculateFreePlaces() {
        return this.calculateMaximalNumberOfChildren() - presentChildren;
    }

    public void addChild(Child child) {
        if (calculateFreePlaces() > 0) {
            this.children.add(child);
        } else {
            System.out.println("no free places available");
        }
    }

    public void removeChild(Child child) {
        children.stream().forEach(o1 -> {
            if (o1.equals(child)) {
                children.remove(o1);
                presentChildren--;
            }
        });
    }

    public void addToy(Toy toy) {
        if (moneyAvailable > toy.getPrice()) {
            moneyAvailable -= toy.getPrice();
            this.toys.add(toy);
        } else {
            System.out.println("not enough money to buy this toy");
        }
    }

}
