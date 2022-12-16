package BigInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BigInteger {

    private List<Integer> m_listOfInt;

    public BigInteger(List<Integer> listOfInt) {
        m_listOfInt = listOfInt;
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
        final int subtract = Math.addExact(num1, num2);
        return numberToList(subtract);
    }

    private static List<Integer> subtractLists(List<Integer> list1, List<Integer> list2) {
        final int num1 = listToNumber(list1);
        final int num2 = listToNumber(list2);
        final int subtract = Math.abs(Math.subtractExact(num1, num2));
        return numberToList(subtract);
    }

    private static List<Integer> multiplyLists(List<Integer> list1, List<Integer> list2) {
        final int num1 = listToNumber(list1);
        final int num2 = listToNumber(list2);
        final int multiply = Math.abs(Math.multiplyExact(num1, num2));
        return numberToList(multiply);
    }

    @Override
    public final String toString() {
        final String result = m_listOfInt.toString().replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "");
        return result;
    }

    public final void add(BigInteger bigInteger) {
        m_listOfInt = addLists(m_listOfInt, bigInteger.get());
    }

    public final void subtract(BigInteger bigInteger) {
        m_listOfInt = subtractLists(m_listOfInt, bigInteger.get());
    }

    public final void multiply(BigInteger bigInteger) {
        m_listOfInt = multiplyLists(m_listOfInt, bigInteger.get());
    }

    private List<Integer> get() { // integerValue()
        return this.m_listOfInt;
    }

    public final int integerValue() {
        final int integerNum = listToNumber(m_listOfInt);
       /* if (integerNum > Integer.MAX_VALUE || integerNum < 0) {
            throw new ArithmeticException("Overflow!");
        }*/
        return (int) integerNum;

    }

}
