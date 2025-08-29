import java.util.Arrays;
import java.util.List;

public class Student {

    @FunctionalInterface
    public interface StudentFilter {
        boolean test(Student student);
    }

    private final String name;
    private final int age;

    public double getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    private final double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", grade: " + grade;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 19, 72.4),
                new Student("Bob", 23, 58.1),
                new Student("Charlie", 21, 84.7),
                new Student("Diana", 20, 91.2),
                new Student("Eve", 25, 36.5),
                new Student("Frank", 22, 67.8),
                new Student("Grace", 18, 54.9),
                new Student("Heidi", 20, 77.6),
                new Student("Ivan", 24, 62.3),
                new Student("Judy", 19, 88.0)
        );
        List<Student> filtered = students.stream()
                .filter(student -> student.getAge() > 20 && student.getGrade() > 70)
                .toList();
        System.out.println(filtered.toString());
    }


}