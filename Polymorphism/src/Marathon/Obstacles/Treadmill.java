package Marathon.Obstacles;

import Marathon.Participants.Cat;
import Marathon.Participants.Human;
import Marathon.Participants.Participant;
import Marathon.Participants.Robot;

public final class Treadmill implements Obstacle {

    private final int length;

    public Treadmill(final int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "treadmill of length: " + length;
    }

    @Override
    public boolean overcome(Participant participant) {
        boolean outcome = false;
        if (participant instanceof Human humanParticipant) {
            outcome = (humanParticipant.resetLuck() || humanParticipant.getMaxRunDistance() >= length);
        }
        else if (participant instanceof Cat catParticipant) {
            outcome = (catParticipant.getMaxRunDistance() >= length);
        }
        else if (participant instanceof Robot robotParticipant) {
            outcome = (robotParticipant.resetSuperCharge() || robotParticipant.getMaxRunDistance() >= length);
        }
        System.out.println(participant.run(outcome) + toString());
        return outcome;
    }

}
