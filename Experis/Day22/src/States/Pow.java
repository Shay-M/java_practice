package States;

import java.util.logging.Level;

public class Pow implements NumberState {
    @Override
    public NumberState nextState(final int number) {
        if ((number % THE_NUMBER) == 0) {
            return Normal.INSTANCE;
        }
        if (String.valueOf(number).contains(String.valueOf(THE_NUMBER))) {
            return this;  // Pow
        }
        return this; // Pow
    }

    @Override
    public void printStatus(final int number) {
        logger.log(Level.INFO, number + " POW");
    }
}
