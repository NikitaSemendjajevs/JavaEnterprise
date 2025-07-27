import java.util.*;

public class Homework {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(List.of(
                "apple", "banana", "apple", "cherry", "banana",
                "date", "cherry", "apple", "banana", "date"
        ));
        List<String> occurrences = findOccurrence(words);
        System.out.println(occurrences);


    }

    public static int countOccurrence(List<String> words, String word) {
        int occurrence = 0;
        for (String s: words) {
            occurrence  += (s.equals(word)) ? 1 : 0;
        }
        return occurrence;
    }

    public static List<Integer> toList(int... ints) {
        List<Integer> list = new ArrayList<>();
        for (Integer i: ints) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> findUnique(List<Integer> ints) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i: ints) {
            if (!map.containsKey(i)) {
                map.put(i,1);
                list.add(i);
            }
        }
        return list;
    }

    public static List<String> findOccurrence(List<String> strings) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (String s: strings) {

            if (!map.containsKey(s)) {
                map.put(s,1);
                list.add("Word: " + s + ", occurrence: " + 1);
            }
            else {
                int index = list.indexOf("Word: " + s + ", occurrence: " + map.get(s));
                map.replace(s, map.get(s)+1);
                list.remove(index);
                list.add(index, "Word: " + s + ", occurrence: " + map.get(s));
            }

        }

        return list;
    }

}
