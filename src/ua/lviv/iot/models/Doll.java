package models;

public class Doll extends Toy {

    private String name;

    public Doll(double price, Size size) {
        super(price, size);
        switch (size) {
            case SMALL:
            {
                this.setToyType(ToyType.DOLL_SMALL);
            } break;
            case MEDIUM:
            {
                this.setToyType(ToyType.DOLL_MEDIUM);
            } break;
            case LARGE:
            {
                this.setToyType(ToyType.DOLL_LARGE);
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
        System.out.println("Playing with a doll");
    }

}
