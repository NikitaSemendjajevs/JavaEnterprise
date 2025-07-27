import java.util.Arrays;
import java.util.List;

public class DynamicArray {

    private int[] ints;
    private int size;

    public DynamicArray() {
        ints = new int[10];
        size = 0;
    }

    public int getAtIndex(int index) throws NullPointerException {
        if (index < -1 || index > ints.length) {
            throw new NullPointerException();
        }
        else {
            return ints[index];
        }
    }

    public void add(int i) {
        if (size == 0) {
            ints[0] = i;
        }
        else if (size == ints.length) {
            ints = resize(ints);
            ints[size] = i;
        }
        else {
            ints[size] = i;
        }
        size++;
    }

    public int size() {
        return ints.length;
    }

    private int[] resize(int[] ints) {
        int[] temp = new int[(int)(ints.length * 1.5)];
        for (int i = 0; i < size; i++) {
            temp[i] = ints[i];
        }
        ints = temp;
        return ints;
    }

    @Override
    public String toString() {
        return Arrays.toString(ints);
    }

}