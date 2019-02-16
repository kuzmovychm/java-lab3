package models;

public abstract class Toy<T> {

    private double price;
    private Size size;
    private String toyType;

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

    public String getToyType() {
        return toyType;
    }

    public void setToyType(String toyType) {
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
