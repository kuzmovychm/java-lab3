package models;

public class Ball extends Toy {

    private String color;

    public Ball(double price, Size size) {
        super(price, size);
        switch (size) {
            case SMALL:
            {
                this.setToyType("small ball");
            } break;
            case MEDIUM:
            {
                this.setToyType("medium ball");
            } break;
            case LARGE:
            {
                this.setToyType("large ball");
            }break;
        }
    }

    public Ball(double price, Size size, String color) {
        this(price, size);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "price=" + this.getPrice() +
                ", size=" + this.getSize() +
                ", toyType='" + this.getToyType() + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void play() {

    }

}
