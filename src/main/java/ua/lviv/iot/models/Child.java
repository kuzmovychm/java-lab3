package main.java.ua.lviv.iot.models;

public class Child {

    private int age;
    private String name;
    private String parentName;

    public Child(int age, String name, String parentName) {
        this.age = age;
        this.name = name;
        this.parentName = parentName;
    }

    //do I really need getters and setters in this class?

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return age == child.age &&
                name.equals(child.name) &&
                parentName.equals(child.parentName);
    }

}
