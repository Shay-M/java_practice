package States;

import java.util.logging.Logger;

public interface NumberState {
    static final Logger logger = Logger.getLogger(NumberState.class.getCanonicalName());
    final static int THE_NUMBER = 7;

    NumberState nextState(int number);
    void printStatus(int number);
}
