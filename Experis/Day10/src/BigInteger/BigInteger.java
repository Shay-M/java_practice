package BigInteger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BigInteger {
    private List<Integer> m_listOfInt;

    public BigInteger(List<Integer> listOfInt) {
        m_listOfInt = listOfInt;
        // Add add = new Add();
    }

    public BigInteger(int number) {
        m_listOfInt = numberToList(number);
    }

    public BigInteger(Integer number) {
        m_listOfInt = numberToList(number);
    }

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

    private static int listToNumber(List<Integer> listToConvert) {
        if (listToConvert.isEmpty()) {
            return 0;
        }
        final ListIterator<Integer> iteratorListToConvert = listToConvert.listIterator();
        int numToReturn = 0;
        int dig = 1;
        while (iteratorListToConvert.hasNext()) {
            //numToReturn += iteratorListToConvert.previous() * dig;
            numToReturn = Math.addExact(numToReturn, iteratorListToConvert.next() * dig);
            dig *= 10;
        }
        return numToReturn;
    }


    public final void add(final BigInteger bigInteger) {
        try {
            m_listOfInt = addListsByConvert(m_listOfInt, bigInteger.m_listOfInt);
        } catch (ArithmeticException ex) {
            m_listOfInt = addListsBigInt(m_listOfInt, bigInteger.m_listOfInt);
        }
    }

    private List<Integer> addListsByConvert(final List<Integer> list1, final List<Integer> list2) {
        final int num1 = listToNumber(list1);
        final int num2 = listToNumber(list2);
        final int subtract = Math.addExact(num1, num2);
        return numberToList(subtract);
    }

    private List<Integer> addListsBigInt(final List<Integer> list1, final List<Integer> list2) {
        final ListIterator<Integer> iteratorList1 = list1.listIterator();
        final ListIterator<Integer> iteratorList2 = list2.listIterator();
        final int ListArraySize = 1 + Math.max(list1.size(), list2.size()); // was list1.size() > list2.size() ? list1.size(): list2.size();
        final List<Integer> listToReturn = new ArrayList<>(ListArraySize);
        final ListIterator<Integer> iteratorListToReturn = listToReturn.listIterator();
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
            iteratorListToReturn.add(sum);
            iteratorListToReturn.previous();
        }
        if (remained > 0) {
            listToReturn.add(remained);
        }
        while (iteratorList1.hasNext()) {
            iteratorListToReturn.add(iteratorList1.next());
            iteratorListToReturn.previous();
        }
        while (iteratorList2.hasNext()) {
            iteratorListToReturn.add(iteratorList2.next());
            iteratorListToReturn.previous();
        }
        return listToReturn;

    }

    public final void subtract(BigInteger bigInteger) {
        try {
            m_listOfInt = subtractListsByConvert(m_listOfInt, bigInteger.m_listOfInt);
        } catch (ArithmeticException ex) {
            m_listOfInt = subtractListsBigInt(m_listOfInt, bigInteger.m_listOfInt);
        }
    }

    private static List<Integer> subtractListsByConvert(List<Integer> list1, List<Integer> list2) {
        final int num1 = listToNumber(list1);
        final int num2 = listToNumber(list2);
        final int subtract = Math.abs(Math.subtractExact(num1, num2));
        return numberToList(subtract);
    }

    private List<Integer> subtractListsBigInt(final List<Integer> list1, final List<Integer> list2) {

        return null;
    }

    public final void multiply(BigInteger bigInteger) {
        try {
            m_listOfInt = multiplyListsByConvert(m_listOfInt, bigInteger.m_listOfInt);
        } catch (ArithmeticException ex) {
            m_listOfInt = multiplyListsBigInt(m_listOfInt, bigInteger.m_listOfInt);
        }
    }

    private static List<Integer> multiplyListsByConvert(List<Integer> list1, List<Integer> list2) {
        final int num1 = listToNumber(list1);
        final int num2 = listToNumber(list2);
        final int multiply = Math.abs(Math.multiplyExact(num1, num2));
        return numberToList(multiply);
    }

    private List<Integer> multiplyListsBigInt(final List<Integer> list1, final List<Integer> list2) {

        final int ListArraySize = list1.size() + list2.size(); // was list1.size() > list2.size() ? list1.size(): list2.size();
        final List<Integer> listToReturn = new ArrayList<>(ListArraySize);
        return null;
    }

    @Override
    public final String toString() {
        final String result = m_listOfInt.toString().replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "");
        return result;
    }

    public final int integerValue() {
        final int integerNum = listToNumber(m_listOfInt);
        if (integerNum > Integer.MAX_VALUE || integerNum < 0) {
            throw new ArithmeticException("Overflow!");
        }
        return integerNum;

    }

}
