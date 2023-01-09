import States.Normal;
import States.NumberState;

import java.util.logging.Logger;

public class StatePattern {
    final static int MAX_NUMBER = 100;
    final static int START_NUMBER = 1;

    public static void main(final String[] args) {
        NumberState numberState = Normal.INSTANCE;
        for (int i = START_NUMBER; i <= MAX_NUMBER; ++i) {
            numberState = numberState.nextState(i);
            numberState.printStatus(i);
        }
    }
}