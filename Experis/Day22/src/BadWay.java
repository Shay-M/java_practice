import java.util.logging.Level;
import java.util.logging.Logger;

public final class BadWay {
    private static final Logger logger = Logger.getLogger(BadWay.class.getCanonicalName());
    final static int MAX_NUMBER = 40;
    final static int THE_NUMBER = 1;

    public static void main(final String[] args) {
        boolean isDividedBy = false;
        boolean isConstant = false;

        boolean normalState = true;
        boolean boomState = false;
        boolean kaboomState = false;
        boolean powState = false;

        for (int i = 1; i < MAX_NUMBER; i++) {

            if (i % THE_NUMBER == 0) {
                isDividedBy = true;
            }
            else if (Integer.toString(i).contains(String.valueOf(THE_NUMBER))) {
                isConstant = true;
            }

            if (isDividedBy) {
                if (normalState) {
                    normalState = false;
                    boomState = !boomState;
                }
                else if (boomState) {
                    normalState = true;
                    boomState = false;
                }
                else if (powState) {
                    normalState = true;
                    powState = false;
                }
                else if (kaboomState) {
                    normalState = true;
                    kaboomState = !kaboomState;
                }

                isDividedBy = false;
            }
            else if (isConstant) {
                if (normalState) {
                    normalState = false;
                    powState = !powState;
                }
                else if (boomState) {
                    kaboomState = true;
                    boomState = false;
                }
                else if (powState) {
                    normalState = true;
                    powState = false;
                }
                else if (kaboomState) {
                    normalState = true;
                    kaboomState = !kaboomState;
                }
                isConstant = false;
            }
            logger.log(Level.INFO, "" + i + " " + (kaboomState ? "Ka-Boom" : "")
                    + (boomState ? "Boom" : "") + (powState ? "Pow" : ""));
        }
    }
}
