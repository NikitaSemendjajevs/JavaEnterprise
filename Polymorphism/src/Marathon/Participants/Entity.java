package Marathon.Participants;

public abstract class Entity implements Participant {

    private final String name;
    private final int maxRunDistance;
    private final int maxJumpHeight;
    private boolean isActiveParticipant;

    Entity (final String name, final int maxRunDistance, final int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.isActiveParticipant = true;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public boolean getIsActiveParticipant() {
        return isActiveParticipant;
    }

    public void setIsActiveParticipant(boolean b) {
        isActiveParticipant = b;
    }

    @Override
    public String run(boolean result) {
        return (result) ? toString() + " has overcome the " : toString() + " is eliminated because he hasn't overcome the ";
    }

    @Override
    public String jump(boolean result) {
        return (result) ? toString() + " has overcome the " : toString() + " is eliminated because he hasn't overcome the ";
    }

}
