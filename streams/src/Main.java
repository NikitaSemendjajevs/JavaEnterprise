import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    /*
    Необходимо реализовать метод, генерирующий список из 100 случайных чисел
    в диапазоне от 1 до 1000. Далее, данный метод должен найти топ-10 минимальных
    значений, затем исключить повторяющиеся значения, и в конечном итоге отсортировать
    оставшиеся числа в порядке убывания. Результат выполнения вывести в консоль.
    */

    public static void generateAndPrintTop10DescendingUniqueNumbers() {
        List<Integer> list = new Random()
                .ints(100, 1, 1001)
                .boxed()
                .toList();

        List<Integer> sortedUniqueList = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

        for (int i = 0; i < Math.min(10, sortedUniqueList.size()); i++) {
            System.out.println(sortedUniqueList.get(i));
        }
    }

    /*
    Необходимо реализовать метод, принимающий в качестве аргумента
    обобщенный Collection и обобщенный Predicate. Метод должен выполнить
    фильтрацию переданной коллекции на основании предиката и в качестве
    результата выполнения вернуть новый отфильтрованный экземпляр коллекции.
    */

    public static <E> List<E> filter(Collection<E> collection, Predicate<E> predicate) {
        return collection.stream()
                .filter(predicate)
                .toList();
    }

    /*
    Необходимо реализовать метод, принимающий в качестве аргумента коллекцию строк
    и Predicate, работающий со строками. Метод должен выполнить фильтрацию переданной
    коллекции на основании предиката, затем соединить все отфильтрованные строки между
    собой при помощи разделителя. Разделителем соединяемых строк выступает символ "|".

    В качестве результата выполнения необходимо вернуть строку, состоящую из
    отфильтрованных строк, соединенных при помощи разделителя.

    Пример результата: "hello|,|world|!"
    */

    public static String filterString(Collection<String> strings, Predicate<String> predicate) {
        Collection<String> filtered = strings
                .stream()
                .filter(predicate)
                .toList();
        return filtered.toString();
    }

    /*
    Необходимо реализовать метод, принимающий в качестве аргумента коллекцию,
    содержащую произвольные неуникальные числа, и направление сортировки (ASC, DESC).

    Метод должен проинициализировать новую коллекцию, содержащую только уникальные числа,
    отсортированные в соответствии с переданным направлением, и вернуть её
    в качестве результата выполнения.
    */

    public static Collection<Integer> findAndSortUniqueIntegers(Collection<Integer> integers, Comparator<Integer> comparator) {
        return integers.stream()
                .distinct()
                .sorted(comparator)
                .toList();
    }

    /*
    Необходимо реализовать метод, принимающий в качестве аргумента целое число
    и вычисляющий факториал данного числа. В качестве результата выполнения
    необходимо вернуть целое число, отображающее вычисленный факториал.
    */

    public static int findFactorial(int i) {
        return IntStream.rangeClosed(1, i)
                .reduce(1, (a, b) -> a * b);
    }



}



