package ArrayIterator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(OddIterator.Main.class.getCanonicalName());

    public static void main(String[] args) {

        final Integer[] artNum = {1, 2, 3, 9};
        final ArrayIterator<Integer> itr = new ArrayIterator<Integer>(artNum);
        while (itr.hasNext()) {
            logger.log(Level.INFO, "" + itr.next());
        }

        final String[] artStr = {"a", "s", " o", "s"};
        final ArrayIterator<String> itrs = new ArrayIterator<String>(artStr);
        while (itrs.hasNext()) {
            logger.log(Level.INFO, "" + itrs.next());
        }
    }
}
