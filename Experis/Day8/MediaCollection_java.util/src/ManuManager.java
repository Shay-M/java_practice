import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * get number command from the user
 */
public class ManuManager {


    public final static int getCommandNum(Logger logger, int maxCommand) {
        final int commandNum;

        try {
            commandNum = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException ex) {
            logger.log(Level.INFO, "Exit!");
            throw new NumberFormatException();
        }

        if (commandNum > maxCommand || commandNum <= 0) {
            throw new IllegalArgumentException();
        }

        return commandNum - 1;
    }

}
