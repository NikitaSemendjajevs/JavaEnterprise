package Homework;

abstract class AnimalThatCanSwim extends Animal{

    AnimalThatCanSwim(final String name, int age) {
        super(name, age);
    }

    @Override
    public abstract void run(int distance) throws DistanceIsTooLong;

    public abstract void swim(int distance) throws DistanceIsTooLong;

}
