import java.io.*;
import java.math.BigDecimal;

public class Employee {

    interface Filterable {
        boolean filter(Employee employee);
    }

    private String fullName;
    private String occupation;
    private String email;
    private int age;
    private long phoneNumber;
    private BigDecimal salary;

    // Default constructor
    Employee() {
        this.fullName = "Full Name";
        this.occupation = "Occupation";
        this.email = "mail@email.com";
        this.age = 0;
        this.phoneNumber = 0;
        this.salary = new BigDecimal(0);
    }

    Employee(String fullName, String occupation, String email, int age, long phoneNumber, BigDecimal salary) {
        this.fullName = fullName;
        this.occupation = occupation;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    // This method works with raw bytes
    public static void print(OutputStream outputStream, Employee employee) throws IOException {

        byte[] bytes = employee.toString().getBytes(); //writes the full byte array (it's more efficient than writing one byte at a time)
        outputStream.write(bytes);
        outputStream.write('\n');
        outputStream.flush();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", salary=" + salary +
                '}';
    }

    public static void filterEmployees(Employee[] employees, int age) {

        class EmployeeFilter implements Filterable {

            private final int ageParameter;

            EmployeeFilter(final int ageParameter) {
                this.ageParameter = ageParameter;
            }

            @Override
            public boolean filter(Employee employee) {
                return employee.getAge() >= this.ageParameter;
            }

        }

        EmployeeFilter filter = new EmployeeFilter(age);

        for (Employee employee: employees) {
            if (filter.filter(employee)) {
                System.out.println(employee);
            }
        }

    }

    private int getAge() {
        return this.age;
    }

    public static void main(String[] args) throws IOException {

        Employee[] employees = {
                new Employee("Alice Brown", "Software Engineer", "alice.brown@example.com", 29, 447911223344L, new BigDecimal("55000.00")),
                new Employee("Bob Smith", "DevOps Engineer", "bob.smith@example.com", 34, 447922334455L, new BigDecimal("60000.00")),
                new Employee("Clara Jones", "QA Analyst", "clara.jones@example.com", 27, 447933445566L, new BigDecimal("48000.00")),
                new Employee("Daniel White", "Product Manager", "daniel.white@example.com", 41, 447944556677L, new BigDecimal("75000.00")),
                new Employee("Eva Green", "UX Designer", "eva.green@example.com", 31, 447955667788L, new BigDecimal("53000.00"))
        };

        Employee employee = new Employee();

        /*Copies ONE byte at a time (inefficient)
        * try-with-resources block closes a stream automatically */
        /*try (FileOutputStream outputStream = new FileOutputStream("")) {
            Employee.print(outputStream, employee);
        }*/

        // Stores data in memory -> writes to a file when the buffer is full or flush()/close()
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("/Users/nikitasemendjajevs/Desktop/list_of_employees_40_years_old"))) {
            Employee.print(bufferedOutputStream, employee);
        }

        /* Automatically converts data (numbers, objects, strings) into text. Do not use when work with audio or images.
        *  Doesn't make sense to use it here because the method does not leverage print() or println() methods */
        /*try (PrintStream printStream = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("/Users/nikitasemendjajevs/Desktop/list_of_employees_40_years_old")))) {
            Employee.print(printStream, employee);
        }*/

    }

}
