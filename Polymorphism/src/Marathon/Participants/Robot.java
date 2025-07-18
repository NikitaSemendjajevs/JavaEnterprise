package Marathon.Participants;

import java.util.Random;

public final class Robot extends Entity {

    private boolean superCharge;

    public Robot(final String name, final int maxRunDistance, final int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
        superCharge = setSuperCharge();
    }

    private boolean setSuperCharge() {
        Random randomSuperCharge = new Random();
        int value = randomSuperCharge.nextInt(0,2);
        return value == 1;
    }

    public boolean resetSuperCharge() {
        boolean valueToReturn = superCharge;
        superCharge = setSuperCharge();
        return valueToReturn;
    }

}
