package Marathon.Participants;

import java.util.Random;

public final class Cat extends Entity {

    private boolean superJump;

    public Cat(final String name, final int maxRunDistance, final int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
        superJump = setSuperJump();
    }

    private boolean setSuperJump() {
        Random randomSuperJump = new Random();
        int value = randomSuperJump.nextInt(0,2);
        return value == 1;
    }

    public boolean resetSuperJump() {
        boolean valueToReturn = superJump;
        superJump = setSuperJump();
        return valueToReturn;
    }

}
