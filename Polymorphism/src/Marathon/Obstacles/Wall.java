package Marathon.Obstacles;

import Marathon.Participants.Cat;
import Marathon.Participants.Human;
import Marathon.Participants.Participant;
import Marathon.Participants.Robot;

public final class Wall implements Obstacle {

    private final int height;

    public Wall(final int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "wall of height: " + height;
    }

    @Override
    public boolean overcome(Participant participant) {
        boolean outcome = false;
        if (participant instanceof Human humanParticipant) {
            outcome = (humanParticipant.resetLuck() || humanParticipant.getMaxJumpHeight() >= height);
        }
        else if (participant instanceof Cat catParticipant) {
            outcome = (catParticipant.resetSuperJump() || catParticipant.getMaxJumpHeight() >= height);
        }
        else if (participant instanceof Robot robotParticipant) {
            outcome = (robotParticipant.getMaxJumpHeight() >= height);
        }
        System.out.println(participant.jump(outcome) + toString());
        return outcome;
    }

}
