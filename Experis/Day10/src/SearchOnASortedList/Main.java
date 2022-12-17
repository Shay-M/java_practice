package SearchOnASortedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(BigInteger.Main.class.getCanonicalName());

    public static void main(String[] args) {
        final List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(9);

        logger.log(Level.INFO, "find 6: " + SearchOnASortedList(list, 6));
        logger.log(Level.INFO, "find 9: " + SearchOnASortedList(list, 9));
        logger.log(Level.INFO, "find 0: " + SearchOnASortedList(list, 0));
    }

    private static int SearchOnASortedList(final List<Integer> list, final int varToSearch) {
        final ListIterator<Integer> listIterator = list.listIterator();
        int index = -1;
        while (listIterator.hasNext()) {
            final int valInNod = listIterator.next();
            ++index;
            if (valInNod > varToSearch) {
                return -1;
            } else if (varToSearch == valInNod) {
                return index;
            }
        }
        return -1;
    }
}
