package Homework;

public abstract class Animal {

    private final String name;
    private int age;
    protected static int totalNumberOfAnimals = 0;


    protected Animal(final String name, int age) {
        this.name = name;
        this.age = age;
        totalNumberOfAnimals++;
    }

    protected String getName() {
        return this.name;
    }

    protected int getAge() {
        return this.age;
    }

    public abstract void run(int distance) throws DistanceIsTooLong;

    public static int getTotalNumberOfAnimals() {
        return totalNumberOfAnimals;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + ", age: " + this.getAge();
    }

}
