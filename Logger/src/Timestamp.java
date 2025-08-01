import java.time.*;
import java.util.*;
import java.util.function.Consumer;

public class Timestamp {

    private final User visitor;
    private final LocalDate dateOfVisit;
    private final List<String> timeOfVisits;
    private final List<Integer> hoursTracker;

    public Timestamp(final User user) {
        visitor = user; dateOfVisit = LocalDate.now();
        String time = "Date: " + dateOfVisit + ", Time: " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute();
        timeOfVisits = new ArrayList<>();
        timeOfVisits.add(time);
        hoursTracker = new ArrayList<>();
        hoursTracker.add(LocalTime.now().getHour());
    }

    public final User getVisitor() {
        return visitor;
    }

    public int getTotalNumberOfVisits() {
        return timeOfVisits.size();
    }

    public void registerNewVisit() {
        String time = "Date: " + dateOfVisit + ", Time: " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute();
        timeOfVisits.add(time);
        hoursTracker.add(LocalTime.now().getHour());
    }

    public int getHourMode() {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer hour : hoursTracker) {
            if (!map.containsKey(hour)) {
                map.put(hour, 1);
            } else {
                map.replace(hour, map.get(hour) + 1);
            }
        }

        int hour = 0;
        int frequency = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > frequency) {
                frequency = entry.getValue();
                hour = entry.getKey();
            }
        }
        return hour;
    }

    @Override
    public String toString() {
        return timeOfVisits.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o instanceof Timestamp timestamp) {
            return visitor.equals(timestamp.visitor) && dateOfVisit.equals(timestamp.dateOfVisit);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = visitor.hashCode();
        for (String time: timeOfVisits) {
            result = 31 * result + time.hashCode();
        }
        return result * 31 * result + dateOfVisit.hashCode();
    }

}
