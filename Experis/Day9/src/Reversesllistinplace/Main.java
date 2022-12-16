package Reversesllistinplace;
//- In-place means that is changes the same list that it receives as an argument to the function.
//- The function DOES NOT create a new list.
//- Calculate the Complexity of the function if the function if the List passed to it as an ArrayList.
//- Calculate the Complexity of the function if the function if the List passed to it as a LinkedList.
//- Is it possible to implement the function with Complexity O(N) for BOTH types of List? (Note that List supports a listIterator() method)
// Example: the list ["a", "b", "c"] will be changed into ["c", "b", "a"]


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        final List<String> listOfLetters = new LinkedList<String>();
        listOfLetters.add("a");
        listOfLetters.add("b");
        listOfLetters.add("c");

        logger.log(Level.INFO, "Before LinkedList " + listOfLetters);
        ReversesListWithListIterator(listOfLetters);
        logger.log(Level.INFO, "After LinkedList. " + listOfLetters);
    }

    private static void ReversesList(List listOfLetters) { // O()
        final int sizeList = listOfLetters.size(); // LinkedList: 1 | ArrayList: 1
        for (int i = 0; i < sizeList; i++) {
            listOfLetters.add(i, listOfLetters.get(listOfLetters.size() - 1)); // LinkedList: add: 1 + get: N | ArrayList: add: N + get: 1
            listOfLetters.remove(listOfLetters.size() - 1); // LinkedList: remove: N | ArrayList: remove: N
        }
    }
    private static void ReversesListWithListIterator(List listOfLetters) { // O(N)
        final ListIterator<String> iteratorListToReturnFromStart = listOfLetters.listIterator();

        final int listSize = listOfLetters.size();
        for (int index = 0; index < listSize / 2; ++index) { // N/2 *

        }
    }

}

