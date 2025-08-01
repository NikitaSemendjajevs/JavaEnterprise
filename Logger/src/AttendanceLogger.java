import java.util.*;
import java.util.function.Consumer;

public class AttendanceLogger {

    private final Map<User, Timestamp> attendanceLogger;

    public AttendanceLogger() {
        attendanceLogger = new HashMap<>();
    }

    public void addLog(User user) {
        if (!attendanceLogger.containsKey(user)) {
            attendanceLogger.put(user, new Timestamp(user));
        }
        else {
            attendanceLogger.get(user).registerNewVisit();
        }
    }

    public int getTotalNumberOfVisitsOf(User user) throws UserNotFoundException {
        if (!attendanceLogger.containsKey(user)) {
            throw new UserNotFoundException("User doesn't exist");
        }
        return attendanceLogger.get(user).getTotalNumberOfVisits();
    }

    public int findHourMode() {
        ArrayList<Integer> modes = new ArrayList<>();
        for (Map.Entry<User,Timestamp> entry: attendanceLogger.entrySet()) {
            modes.add(entry.getValue().getHourMode());
        }
        Collections.sort(modes);
        return modes.getLast();
    }

    public void printAttendanceLogger() {
        for (Timestamp timestamp: attendanceLogger.values()) {
            System.out.println(timestamp.getVisitor() + ", Date: " + timestamp + ", Visits: " + timestamp.getTotalNumberOfVisits());
        }
    }

    @Override
    public String toString() {
        return attendanceLogger.toString();
    }

    public static void main(String[] args) {

        User user = new User("Nikita");
        User userTwo = new User("Anna");

        AttendanceLogger attendanceLogger = new AttendanceLogger();

        attendanceLogger.addLog(user);
        attendanceLogger.addLog(userTwo);
        attendanceLogger.addLog(user);

        //System.out.println(attendanceLogger);
        attendanceLogger.printAttendanceLogger();
        System.out.println(attendanceLogger.findHourMode());

    }

}
