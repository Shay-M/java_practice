package States;

import java.util.logging.Level;

public class Normal implements NumberState {
    public static final Normal INSTANCE = new Normal();

    private Normal() {
        // for Singleton
    }

    @Override
    public NumberState nextState(final int number) {
        if ((number % THE_NUMBER) == 0) {
            return new Boom();
        }
        if (String.valueOf(number).contains(String.valueOf(THE_NUMBER))) {
            return new Pow();
        }
        return this; // Normal
    }

    @Override
    public void printStatus(final int number) {
        logger.log(Level.INFO, "" + number);

    }
}
