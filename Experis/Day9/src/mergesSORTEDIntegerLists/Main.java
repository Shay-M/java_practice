package mergesSORTEDIntegerLists;
//Write a function that merges two SORTED Integer lists into a new sorted list. [1,4,6],[2,3,5] → [1,2,3,4,5,6].
//- IMPORTANT: This function will only work if the two lists given as arguments are already sorted.
//- The list CAN contain duplicate values, i.e. [1, 4, 4, 4, 6, 7, 7, 12]
//- The function should have a complexity of O(N).
//- Do not us sorting! The best possible complexity for sorting is O(N*logN) - which is larger than O(N).


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {

        final List<Integer> listOfLatters = new ArrayList<Integer>();
        listOfLatters.add(1);
        listOfLatters.add(4);
        listOfLatters.add(6);

        final List<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(2);
        listOfNumbers.add(3);
        listOfNumbers.add(5);


        logger.log(Level.INFO, "" + CombinesListsOfIntegerAlternatingly(listOfLatters, listOfNumbers));

    }

    private final static List<Integer> CombinesListsOfIntegerAlternatingly(List<Integer> first, List<Integer> second) {
        final ArrayList<Integer> newList = new ArrayList<Integer>(); //1

        final Iterator<Integer> itFirst = first.iterator(); //1
        final Iterator<Integer> itSecond = second.iterator(); //1

        while (itFirst.hasNext() && itSecond.hasNext()) {
            int num1 = first.get(0);
            int num2 = second.get(0);
            if (num1 < num2) {
                first.remove(0);
                newList.add(num1);
            } else {
                second.remove(0);
                newList.add(num2);
            }
        }

        if (itFirst.hasNext()) {
            newList.addAll(first);
        } else if (itSecond.hasNext()) {
            newList.addAll(second);
        }

        return newList;
    }

}