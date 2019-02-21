package ua.lviv.iot.models;

public abstract class Toy<T> {

    private double price;
    private Size size;
    private ToyType toyType;

    public Toy(double price, Size size) {
        this.price = price;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public void setToyType(ToyType toyType) {
        this.toyType = toyType;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "price=" + price +
                ", size=" + size +
                ", toyType='" + toyType + '\'' +
                '}';
    }

    public abstract void play();

}
