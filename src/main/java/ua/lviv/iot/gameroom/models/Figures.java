package ua.lviv.iot.gameroom.models;

public class Figures extends Toy {

    private int number;
    private String type;

    public Figures() {

    }

    public Figures(double price, Size size) {
        super(price, size);
        switch (size) {
            case SMALL: {
                this.setToyType(ToyType.FIGURES_SMALL);
            } break;
            case MEDIUM: {
                this.setToyType(ToyType.FIGURES_MEDIUM);
            } break;
            case LARGE: {
                this.setToyType(ToyType.FIGURES_LARGE);
            } break;
            default: {
                System.out.println("");
            } break;
        }
    }

    public Figures(double price, Size size, int number, String type) {
        this(price, size);
        this.number = number;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Figures{"
                + "price=" + this.getPrice()
                + ", size=" + this.getSize()
                + ", toyType='" + this.getToyType() + '\''
                + ", number=" + number
                + ", type='" + type + '\''
                + '}';
    }

    @Override
    public void play() {
        System.out.println("Playing with figures");
    }

}
