package models;

public class Doll extends Toy {

    private String name;

    public Doll(double price, Size size) {
        super(price, size);
        switch (size) {
            case SMALL:
            {
                this.setToyType("small doll");
            } break;
            case MEDIUM:
            {
                this.setToyType("medium doll");
            } break;
            case LARGE:
            {
                this.setToyType("large doll");
            }break;
        }
    }

    public Doll(double price, Size size, String name) {
        this(price, size);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Doll{" +
                "price=" + this.getPrice() +
                ", size=" + this.getSize() +
                ", toyType='" + this.getToyType() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void play() {

    }

}
