package CAMP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Camp {

    private final List<Boyscout> boyscoutList;

    public Camp() {
        boyscoutList = new ArrayList<>();
    }

    public void addBoyscout(Boyscout boyscout) {
        boyscoutList.add(boyscout);
    }

    public Map<Boyscout.Team, List<Boyscout>> splitAndSortTeams() {
        return boyscoutList.stream()
                .collect(Collectors.groupingBy(
                        Boyscout::getTeam,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Boyscout::getAge).reversed())
                                        .toList()
                        )
                ));
    }

    public static void main(String[] args) {
        Boyscout boyscoutOne = new Boyscout("Nikita", 27, Boyscout.Team.GREEN);
        Boyscout boyscoutTwo = new Boyscout("Arti", 27, Boyscout.Team.NAVY);
        Boyscout boyscoutThree = new Boyscout("Anna", 26, Boyscout.Team.GREEN);

        Camp camp = new Camp();
        camp.addBoyscout(boyscoutOne);
        camp.addBoyscout(boyscoutTwo);
        camp.addBoyscout(boyscoutThree);

        Map<Boyscout.Team, List<Boyscout>> teams = camp.splitAndSortTeams();

        System.out.println("NAVY Team:");
        teams.get(Boyscout.Team.NAVY).forEach(System.out::println);

        System.out.println("\nGREEN Team:");
        teams.get(Boyscout.Team.GREEN).forEach(System.out::println);
    }
}

