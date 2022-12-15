//Write a function that takes an integer number and returns a list of its digits.

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        final int num = 1357;
        logger.log(Level.INFO, "" + numToList(num));
    }

    private static List<Integer> numToList(final int num) {
        final List<Integer> listToReturn = new LinkedList<Integer>();
        final String numAsString = "" + num;
        final char[] charArray = numAsString.toCharArray();
        for (char ch : charArray) {
            listToReturn.add(ch - '0');
        }
        return listToReturn;
    }

    private static List<Integer> addLists(List<Integer> list1, List<Integer> list2) {

        return null;
    }

}