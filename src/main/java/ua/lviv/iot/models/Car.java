package main.java.ua.lviv.iot.models;

public class Car extends Toy {

    private String type;

    public Car(double price, Size size) {
        super(price, size);
        switch (size) {
            case SMALL:
            {
                this.setToyType(ToyType.CAR_SMALL);
            } break;
            case MEDIUM:
            {
                this.setToyType(ToyType.CAR_MEDIUM);
            } break;
            case LARGE:
            {
                this.setToyType(ToyType.CAR_LARGE);
            }break;
        }
    }

    public Car(double price, Size size, String type) {
        this(price, size);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + this.getPrice() +
                ", size=" + this.getSize() +
                ", toyType='" + this.getToyType() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void play() {
        System.out.println("Playing with a car");
    }

}
