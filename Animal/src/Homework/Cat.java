package Homework;

public class Cat extends Animal {

    private final String breed;
    private final static int RUN_DISTANCE_LIMIT = 200;
    private static int numberOfCatObjects = 0;

    Cat(final String name, int age, final String breed) {
        super(name, age);
        this.breed = breed;
        numberOfCatObjects++;
    }

    private String getBreed() {
        return this.breed;
    }

    public static int getNumberOfCatObjects() {
        return numberOfCatObjects;
    }

    @Override
    public String toString() {
        return super.toString() + ", breed: " + this.getBreed();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (this.getClass() != that.getClass()) return false;
        Cat cat = (Cat) that;
        return this.getName().equals(cat.getName()) &&
                this.getAge() == cat.getAge() &&
                this.breed.equals(cat.breed);
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result * Integer.hashCode(getAge());
        result = 31 * result * getBreed().hashCode();
        return result;
    }

    @Override
    public void run(int distance) throws DistanceIsTooLong {
        if (RUN_DISTANCE_LIMIT - distance < 0) {
            throw new DistanceIsTooLong("Этот кот не может столько пробежать");
        }
        else {
            System.out.println(this.getName() + " пробежал " + distance);
        }
    }

}
