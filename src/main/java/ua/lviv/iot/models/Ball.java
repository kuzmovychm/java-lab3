package ua.lviv.iot.models;

public class Ball extends Toy {

    private String color;

    public Ball() {

    }

    public Ball(double price, Size size) {
        super(price, size);
        switch (size) {
            case SMALL: {
                this.setToyType(ToyType.BALL_SMALL);
            } break;
            case MEDIUM: {
                this.setToyType(ToyType.BALL_MEDIUM);
            } break;
            case LARGE: {
                this.setToyType(ToyType.BALL_LARGE);
            } break;
            default: {
                System.out.println("");
            } break;
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
        return "Ball{"
                + "price=" + this.getPrice()
                + ", size=" + this.getSize()
                + ", toyType='" + this.getToyType() + '\''
                + ", color='" + color + '\''
                + '}';
    }

    @Override
    public void play() {
        System.out.println("Playing with a ball");
    }

}
