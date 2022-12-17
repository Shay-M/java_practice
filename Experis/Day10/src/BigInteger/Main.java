// Write a function that takes an integer number and returns a list of its digits.
package BigInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {

        logger.log(Level.INFO, "" + addLists(numberToList(Integer.MAX_VALUE), numberToList(1)));


//        logger.log(Level.INFO, "numberToList 4321 : " + numberToList(4321));
//        logger.log(Level.INFO, "numberToList 1 : " + numberToList(1));
//
//        logger.log(Level.INFO, "listToNumber [1,3,5,7] : " + listToNumber(numberToList(1357)));
//
//        logger.log(Level.INFO, "[3,2,1] + [3,2,1] = [6,4,2]: " + addLists(numberToList(321), numberToList(321)));
//        logger.log(Level.INFO, "[9] + [3,2,1] = [3,3,0]: " + addLists(numberToList(9), numberToList(321)));
//        logger.log(Level.INFO, "[00] + [3,2,1] = [3,2,1]: " + addLists(numberToList(0), numberToList(321)));
//
//        logger.log(Level.INFO, "[3,2,1] - [3,2,1] = []: " + subtractLists(numberToList(321), numberToList(321)));
//        logger.log(Level.INFO, "[9] - [3,2,1] = [3,3,0]: " + subtractLists(numberToList(9), numberToList(321)));
//        logger.log(Level.INFO, "[00] - [1] = [1]: " + subtractLists(numberToList(0), numberToList(1)));
//
//        logger.log(Level.INFO, "[3,2,1] * [3,2,1] = [103,041]: " + multiplyLists(numberToList(321), numberToList(321)));
//        logger.log(Level.INFO, "[9] * [3,2,1] = [2,889]: " + multiplyLists(numberToList(9), numberToList(321)));
//        logger.log(Level.INFO, "[00] * [1] = [0]: " + multiplyLists(numberToList(0), numberToList(1)));

//        BigInteger bigInteger1 = new BigInteger(Integer.MAX_VALUE);
//        BigInteger bigInteger2 = new BigInteger(1);
//
//        bigInteger1.add(bigInteger2); // bigInteger1 = 10 + 43 = 44
//        logger.log(Level.INFO, " " + bigInteger1);
//        bigInteger1.subtract(bigInteger2); // bigInteger1 = 44 - 34 = 10
//        logger.log(Level.INFO, " " + bigInteger1);
//        bigInteger1.multiply(bigInteger2); // 10 * 34 = 340
//        logger.log(Level.INFO, " " + bigInteger1);
        //logger.log(Level.INFO, " " + bigInteger1.integerValue());

    }
   /* old
    private static List<Integer> numberToList(final int num) {
        final List<Integer> listToReturn = new LinkedList<Integer>();
        final String numAsString = "" + num;
        final char[] charArray = numAsString.toCharArray();
        for (char ch : charArray) {
            listToReturn.add(0, ch - '0');
        }
        return listToReturn;
    }*/

    private static List<Integer> numberToList(int num) {
        final List<Integer> listToReturn = new LinkedList<Integer>();
        final ListIterator<Integer> iteratorToReturn = listToReturn.listIterator();
        if (num == 0) {
            iteratorToReturn.add(0);
            return listToReturn;
        }
        while (num / 10 > 0 || num % 10 > 0) {
            iteratorToReturn.add((int) (num % 10));
            //iteratorToReturn.previous();
            num /= 10;
        }
        return listToReturn;
    }

    private static List<Integer> addLists(List<Integer> list1, List<Integer> list2) {
        final List<Integer> listToReturn = new LinkedList<Integer>();
        // final ListIterator<Integer> iteratorListToReturn = listToReturn.listIterator();
        final ListIterator<Integer> iteratorList1 = list1.listIterator();
        final ListIterator<Integer> iteratorList2 = list2.listIterator();
        if (list1.isEmpty() || list2.isEmpty()) {
            return listToReturn;
        }
        int remained = 0;
        while (iteratorList1.hasNext() && iteratorList2.hasNext()) {
            final int numFromList1 = iteratorList1.next();
            final int numFromList2 = iteratorList2.next();
            int sum = numFromList1 + numFromList2 + remained;
            if (sum > 9) {
                remained = sum / 10;
                sum %= 10;
            }
            // iteratorListToReturn.add(sum);
            listToReturn.add(0, sum);
        }
        if (remained > 0) {
            listToReturn.add(0, remained);
        }
        while (iteratorList1.hasNext()) {
            // iteratorListToReturn.add(iteratorUpsideList1.next());
            listToReturn.add(0, iteratorList1.next());
        }
        while (iteratorList2.hasNext()) {
            // iteratorListToReturn.add(iteratorUpsideList2.next());
            listToReturn.add(0, iteratorList2.next());
        }
        return listToReturn;
    }
}