public class MethodOverriding {

    public static int sum(int... ints) {

        int sum = 0;

        for (Integer i : ints) {
            sum += i;
        }

        return sum;
    }

    public static int sum(int i1, int i2) {
        return i1 + i2;
    }

}

