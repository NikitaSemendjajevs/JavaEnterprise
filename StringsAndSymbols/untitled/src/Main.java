import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(findWordPosition("Apollo target", "pollo"));
    }

    public static int findSymbolOccurrence(String string, char symbol) {
        int symbolOccurrence = 0;
        for (Character ch: string.toCharArray()) {
            if (symbol == ch) {
                symbolOccurrence++;
            }
        }
        return symbolOccurrence;
    }

    public static int findWordPosition(String source, String target) {

        for (int i = 0; i < source.length() - target.length(); i++) {

            int indexOfTarget = 0;
            int indexOfSource = i;
            boolean flag = true;

            while (flag) {

                if (source.charAt(indexOfSource) != target.charAt(indexOfTarget)) {
                    flag = false;
                }
                else if (indexOfTarget == target.length() - 1) {
                    return i;
                }
                else {
                    indexOfTarget++;
                    indexOfSource++;
                }
            }
        }
        return -1;
    }

    public static boolean isPalindrome(String string) {
        for (int i = 0, j = string.length() - 1; i <= j; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static String stringReverse(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = string.length() - 1, j = 0; i >= 0; i--, j++) {
            stringBuilder.append(string.charAt(i));
        }
        string = stringBuilder.toString();
        return string;
    }

}
