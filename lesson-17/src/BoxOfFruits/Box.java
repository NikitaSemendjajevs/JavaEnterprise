package BoxOfFruits;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private final List<T> fruits;

    public Box() {
        fruits =  new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public boolean compare(Box<?> box) {
        return this.getBoxWeight() == box.getBoxWeight();
    }

    public void transfer(Box<T> box) {
        this.fruits.addAll(box.fruits);
    }

    public float getBoxWeight() {
        float boxWeight = 0;
        for (T fruit: fruits) {
            boxWeight += fruit.getWeight();
        }
        return boxWeight;
    }

    @Override
    public String toString() {
        return fruits.toString();
    }

    public static void main(String[] args) {

        Box<Orange> oranges = new Box<>();
        oranges.add(new Orange(0.05f));
        oranges.add(new Orange(0.046f));

        Box<Apple> apples = new Box<>();
        apples.add(new Apple(0.03f));
        apples.add(new Apple(0.04f));

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(0.02f));
        appleBox.add(new Apple(0.03f));

        System.out.println(oranges.compare(apples));
        apples.transfer(appleBox);
        System.out.println();


    }

}
