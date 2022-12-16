//Write a function that takes an integer number and returns a list of its digits.

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "numberToList 4321 : " + numberToList(4321));
        logger.log(Level.INFO, "numberToList 1 : " + numberToList(1));

        logger.log(Level.INFO, "listToNumber [1,3,5,7] : " + listToNumber(numberToList(1357)));

        logger.log(Level.INFO, "[3,2,1] + [3,2,1] = [6,4,2]: " + addLists(numberToList(321), numberToList(321)));
        logger.log(Level.INFO, "[9] + [3,2,1] = [3,3,0]: " + addLists(numberToList(9), numberToList(321)));
        logger.log(Level.INFO, "[00] + [3,2,1] = [3,2,1]: " + addLists(numberToList(0), numberToList(321)));

        logger.log(Level.INFO, "[3,2,1] - [3,2,1] = []: " + subtractLists(numberToList(321), numberToList(321)));
        logger.log(Level.INFO, "[9] - [3,2,1] = [3,3,0]: " + subtractLists(numberToList(9), numberToList(321)));
        logger.log(Level.INFO, "[00] - [1] = [1]: " + subtractLists(numberToList(0), numberToList(1)));

        logger.log(Level.INFO, "[3,2,1] * [3,2,1] = [103,041]: " + multiplyLists(numberToList(321), numberToList(321)));
        logger.log(Level.INFO, "[9] * [3,2,1] = [2,889]: " + multiplyLists(numberToList(9), numberToList(321)));
        logger.log(Level.INFO, "[00] * [1] = [0]: " + multiplyLists(numberToList(0), numberToList(1)));


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
        while (num * 10 / 10 > 0) {
            iteratorToReturn.add(num % 10);
            iteratorToReturn.previous();
            num /= 10;
        }
        return listToReturn;
    }

    private static int listToNumber(List<Integer> listToConvert) {
        if (listToConvert.isEmpty()) {
            return 0;
        }
        final ListIterator<Integer> iteratorListToConvert = listToConvert.listIterator();
        // Moving iterator to the end
        while (iteratorListToConvert.hasNext()) { // N
            iteratorListToConvert.next(); // 1
        }
        int numToReturn = 0;
        int dig = 1;
        while (iteratorListToConvert.hasPrevious()) {
            numToReturn += iteratorListToConvert.previous() * dig;
            dig *= 10;
        }
        return numToReturn;
    }

    private static List<Integer> addLists(List<Integer> list1, List<Integer> list2) {
        final int num1 = listToNumber(list1);
        final int num2 = listToNumber(list2);
        final List<Integer> sumList = numberToList(num1 + num2);
        return sumList;
    }

    private static List<Integer> subtractLists(List<Integer> list1, List<Integer> list2) {
        final int num1 = listToNumber(list1);
        final int num2 = listToNumber(list2);
        int subtract = num1 - num2;
        if (subtract < 0) {
            subtract *= -1;
        }
        final List<Integer> subtractList = numberToList(subtract);
        return subtractList;
    }

    private static List<Integer> multiplyLists(List<Integer> list1, List<Integer> list2) {
        final int num1 = listToNumber(list1);
        final int num2 = listToNumber(list2);
        final List<Integer> multiplyList = numberToList(num1 * num2);
        return multiplyList;
    }

    /*private static List<Integer> addLists(List<Integer> list1, List<Integer> list2) {
        final List<Integer> listToReturn = new LinkedList<Integer>();
        final ListIterator<Integer> iteratorListToReturn = listToReturn.listIterator();
        final List<Integer> upsideList1 = new LinkedList<Integer>();
        final ListIterator<Integer> iteratorList1 = list1.listIterator();
        final List<Integer> upsideList2 = new LinkedList<Integer>();
        final ListIterator<Integer> iteratorList2 = list2.listIterator();

        if (list1.isEmpty() || list2.isEmpty()) {
            return listToReturn;
        }
        while (iteratorList1.hasNext()) { // ? list1.iterator().next()
            upsideList1.add(0, iteratorList1.next());
        }
        while (iteratorList2.hasNext()) {
            upsideList2.add(0, iteratorList2.next());
        }
        final ListIterator<Integer> iteratorUpsideList1 = upsideList1.listIterator();
        final ListIterator<Integer> iteratorUpsideList2 = upsideList2.listIterator();
        int remained = 0;
        while (iteratorUpsideList1.hasNext() && iteratorUpsideList2.hasNext()) {
            final int numFromList1 = iteratorUpsideList1.next();
            final int numFromList2 = iteratorUpsideList2.next();
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
        while (iteratorUpsideList1.hasNext()) { // ? list1.iteratorListToReturn().next()
            // iteratorListToReturn.add(iteratorUpsideList1.next());
            listToReturn.add(0, iteratorUpsideList1.next());
        }
        while (iteratorUpsideList2.hasNext()) {
            // iteratorListToReturn.add(iteratorUpsideList2.next());
            listToReturn.add(0, iteratorUpsideList2.next());
        }
        return listToReturn;
    }*/

}