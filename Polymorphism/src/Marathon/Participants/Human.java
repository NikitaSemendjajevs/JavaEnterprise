package Marathon.Participants;

import java.util.Random;

public final class Human extends Entity {

    private boolean isLucky;

    public Human(final String name, final int maxRunDistance, final int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
        isLucky = setLuck();
    }

    private boolean setLuck() {
        Random randomLuck = new Random();
        int value = randomLuck.nextInt(0,2);
        return value == 1;
    }

    public boolean resetLuck() {
        boolean valueToReturn = isLucky;
        isLucky = setLuck();
        return valueToReturn;
    }

}
