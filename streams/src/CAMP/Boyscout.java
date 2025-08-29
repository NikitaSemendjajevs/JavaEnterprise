package CAMP;

import java.util.logging.Filter;

public class Boyscout {

    public enum Team {
        NAVY,
        GREEN
    }

    private final String name;
    private final int age;
    private final Team team;

    public Boyscout(final String name, final int age, final Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ", team: " + team;
    }

}