package BoxOfFruits;

public abstract class Fruit implements Comparable<Fruit> {

    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Fruit o) {
        return Float.compare(weight, o.weight);
    }

}

