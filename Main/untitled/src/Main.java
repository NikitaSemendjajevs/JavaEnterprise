import javax.print.DocFlavor;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        sortShakerSort(ints);
        //System.out.println(Arrays.toString(ints));

        int[] numsOne = {1, 2, 3, 4, 5};
        int[] numsTwo = new int[0];
        int[] numsThree = {6, 7, 8};
        numsThree = copyArray(numsOne, numsThree);
        System.out.println(Arrays.toString(numsThree));
    }

    public static void sortShakerSort(int[] ints) {

        boolean swapped = true;
        int start = 0;
        int end = ints.length - 1;

        while (swapped) {

            swapped = false;

            for (int i = start; i < end; i++) {
                if (ints[i] > ints[i + 1]) {
                    int temp = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;

            swapped = false;
            end--;

            for (int i = end - 1; i >= start; i--) {
                if (ints[i] > ints[i + 1]) {
                    int temp = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = temp;
                    swapped = true;
                }
            }

            start++;
        }
    }

    public static int[] copyArray(int[] origin, int[] destination) {

        int[] temp = new int[origin.length + destination.length];

        for (int i = 0; i < origin.length; i++) {
            temp[i] = origin[i];
        }
        for (int i = 0; i < destination.length; i++) {
            temp[i + origin.length] = destination[i];
        }

        return temp;

    }

}
