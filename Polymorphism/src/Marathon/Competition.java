    package Marathon;

    import Marathon.Obstacles.*;
    import Marathon.Participants.*;

    import java.util.ArrayList;

    public final class Competition {

        public final int thisCompetitionID;
        public static int competitionID = 0;
        private final ArrayList<Participant> winners;

        Competition () {
            this.thisCompetitionID = competitionID;
            competitionID++;
            winners = new ArrayList<>();
        }

        public int getCompetitionID() {
            return competitionID;
        }

        public void printCompetitionWinners() {
            for (Participant participant: winners) {
                System.out.println("Winner: " + participant);
            }
        }

        public void start(Entity[] entities, Obstacle[] obstacles) {

            boolean result;
            for (Obstacle obstacle: obstacles) {
                for (Entity entity : entities) {

                    if(entity.getIsActiveParticipant()) {
                        result = obstacle.overcome(entity);
                        if(!result) {
                            entity.setIsActiveParticipant(result);
                        }
                    }
                }
            }

            for (Entity entity: entities) {
                if (entity.getIsActiveParticipant()) {
                    winners.add(entity);
                }
            }

        }

        public static void main(String[] args) {
            Entity[] entities = new Entity[] {
                    new Human("Mike", 300, 5),
                    new Cat("Luna", 800, 5),
                    new Robot("XJ-9", 800, 5)
            };

            Obstacle[] obstacles = new Obstacle[] {
                    new Treadmill(500),
                    new Wall(3),
                    new Treadmill(750),
            };

            Competition competition = new Competition();
            competition.start(entities, obstacles);
            competition.printCompetitionWinners();
        }

    }
