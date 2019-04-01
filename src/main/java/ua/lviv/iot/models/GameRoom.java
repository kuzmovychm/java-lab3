package ua.lviv.iot.models;

import java.util.LinkedList;
import java.util.List;

public class GameRoom {

    private AgeGroup ageGroup;
    private double playgroundArea;
    private double moneyAvailable;
    private int presentChildren;
    private List<Toy> toys = new LinkedList<>();
    private List<Child> children = new LinkedList<>();

    public String getHeaders() {
        return "ageGroup," + "playgroundArea," + "moneyAvailable," + "presentChildren";
    }

    public String toCSV() {
        return this.getAgeGroup().toString() + "," + this.getPlaygroundArea() + ","
                    + this.getMoneyAvailable() + "," + this.getPresentChildren();
    }


    public GameRoom() {

    }

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

    public void setPlaygroundArea(double playgroundArea) {
        this.playgroundArea = playgroundArea;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public void setMoneyAvailable(double moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    public void setPresentChildren(int presentChildren) {
        this.presentChildren = presentChildren;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public void setChildren(List<Child> children) {
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
            presentChildren++;
        } else {
            System.out.println("no free places available");
        }
    }

    public void removeChild(Child child) {
        if (child == null) {
            return;
        } else {
//            children.stream().forEach(o1 -> {
//                if (o1.equals(child)) {
//                    children.remove(o1);
//                    presentChildren--;
//                }
//            });
            for (int i = 0; i < presentChildren; i++) {
                if (children.get(i).equals(child)) {
                    children.remove(children.get(i));
                    presentChildren--;
                }
            }
        }
    }

    public void addToy(Toy toy) {
        if (toy == null) {
            return;
        } else {
            if (moneyAvailable > toy.getPrice()) {
                moneyAvailable -= toy.getPrice();
                this.toys.add(toy);
            } else {
                System.out.println("not enough money to buy this toy");
            }
        }
    }

}
