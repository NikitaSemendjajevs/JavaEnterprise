import java.util.Scanner;
import java.util.regex.Pattern;

public final class ArrayValueCalculator {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");

    public static int calculate(String[][] elements) throws ArraySizeException, ArrayDataException {
        validateSize(elements);
        return sumElements(elements);
    }

    private static void validateSize(String[][] elements) throws ArraySizeException {
        if (elements.length != 4) {
            throw new ArraySizeException("The size of an array must be 4x4");
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].length != 4) {
                throw new ArraySizeException("The size of an array must be 4x4");
            }
        }
    }

    private static int sumElements(String[][] elements) throws ArrayDataException {
        int result = 0;
        for (int row = 0; row < elements.length; row++) {
            for (int col = 0; col < elements[row].length; col++) {
                result += parseElements(elements[row][col], row, col);
            }
        }
        return result;
    }

    private static int parseElements(String element, int row, int column) throws ArrayDataException {
        if (element == null || !INTEGER_PATTERN.matcher(element).matches()) {
            throw new ArrayDataException("The following element cannot be converted into an integer.", row + 1, column + 1, element);
        }
        return Integer.parseInt(element);
    }

    public static void main(String[] args) {

        String[][] grid = {
                {"8", "2", "3", "2"},
                {"4", "was", "4", "2"},
                {"7", "8", "0", "1"},
                {"7", "8", "9", "1"}
        };


        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            try {
                System.out.println(ArrayValueCalculator.calculate(grid));
                flag = false;
            }
            catch (ArraySizeException | ArrayDataException exception) {

                System.out.println(exception.getMessage());

                if (exception instanceof ArrayDataException e) {

                    System.out.println("Please enter a valid number: ");
                    String newValue = scanner.nextLine();
                    grid[e.getRow() - 1][e.getColumn() - 1] = newValue;

                }

            }

        }

        scanner.close();

    }
}
