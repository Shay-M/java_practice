import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {

        final Range r1 = new Range(10, 15);
        //for (Object i1 : r1) { was not good bcz we need Range implements Iterable<Integer>
        for (Integer i1 : r1) { // outputs 10, 11, 12, 13, 14 (each in a separate log line)
            logger.log(Level.INFO, String.valueOf(i1));
        }

        final Range r2 = new Range(7, 15, 2);
        for (Object i2 : r2) { // outputs 7, 9, 11, 13 (each in a separate log line)
            logger.log(Level.INFO, String.valueOf(i2));
        }

        final Range r3 = new Range(7, 1, -1);
        for (Object i3 : r3) { // outputs 7, 6, 5, 4, 3, 2 (each in a separate log line)
            logger.log(Level.INFO, String.valueOf(i3));
        }
    }
}