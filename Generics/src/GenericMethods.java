import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethods {

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        swapPairs(integers);
        System.out.println(Arrays.toString(integers));
        List<Integer> list = toList(integers);
    }

    public static <E> void swapPairs(E[] array) {
        for (int i = 0; i < array.length - 1; i += 2) {
            E temp = array[i];
            array[i] = array[i+1];
            array[i+1] = temp;
        }
    }

    public static <E> List<E> toList(E[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

}