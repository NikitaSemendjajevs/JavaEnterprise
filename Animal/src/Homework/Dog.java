package Homework;

public class Dog extends AnimalThatCanSwim {

    private final String breed;
    private final static int RUN_DISTANCE_LIMIT = 500;
    private final static int SWIM_DISTANCE_LIMIT = 10;
    private static int numberOfDogObjects = 0;

    Dog(final String name, int age, final String breed) {
        super(name,age);
        this.breed = breed;
        numberOfDogObjects++;
    }

    private String getBreed() {
        return this.breed;
    }

    public static int getNumberOfDogObjects() {
        return numberOfDogObjects;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (this.getClass() != that.getClass()) return false;
        Dog dog = (Dog) that;
        return this.getName().equals(dog.getName()) &&
                this.getAge() == dog.getAge() &&
                this.breed.equals(dog.breed);
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + Integer.hashCode(getAge());
        result = 31 * result + breed.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", breed: " + this.getBreed();
    }

    @Override
    public void run(int distance) throws DistanceIsTooLong {
        if (RUN_DISTANCE_LIMIT - distance < 0) {
            throw new DistanceIsTooLong("Эта сабака не может столько пробежать");
        }
        else {
            System.out.println(this.getName() + " пробежал " + distance);
        }
    }

    @Override
    public void swim(int distance) throws DistanceIsTooLong {
        if (SWIM_DISTANCE_LIMIT - distance < 0) {
            throw new DistanceIsTooLong("Это сабака не может столько проплыть");
        }
        else {
            System.out.println(this.getName() + " проплыл " + distance);
        }
    }

}
