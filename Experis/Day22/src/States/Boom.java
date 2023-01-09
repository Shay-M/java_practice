package States;

import java.util.logging.Level;

public class Boom implements NumberState {
    @Override
    public NumberState nextState(final int number) {
        if ((number % THE_NUMBER) == 0) {
            return Normal.INSTANCE;
        }
        if (String.valueOf(number).contains(String.valueOf(THE_NUMBER))) {
            return new Kaboom();
        }
        return this; // Boom
    }

    @Override
    public void printStatus(final int number) {
        logger.log(Level.INFO, number + " BOOM!");
    }
}
