package Reversesllistinplace;
//- In-place means that is changes the same list that it receives as an argument to the function.
//- The function DOES NOT create a new list.
//- Calculate the Complexity of the function if the function if the List passed to it as an ArrayList.
//- Calculate the Complexity of the function if the function if the List passed to it as a LinkedList.
//- Is it possible to implement the function with Complexity O(N) for BOTH types of List? (Note that List supports a listIterator() method)


import OddIterator.OddIterator;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {

        final LinkedList<String> listOfLetters = new LinkedList<String>();
        listOfLetters.add("a");
        listOfLetters.add("b");
        listOfLetters.add("c");

        final ArrayList<String> arrayOfLetters = new ArrayList<String>();
        arrayOfLetters.add("a");
        arrayOfLetters.add("b");
        arrayOfLetters.add("c");

        ReversesList(listOfLetters);
        logger.log(Level.INFO, "LinkedList. " + listOfLetters); // N * (1 + 1) \/ N * (1 + N)

        ReversesList(arrayOfLetters);
        logger.log(Level.INFO, "ArrayList. " + arrayOfLetters); // N * (N + 1)

    }

    //Example: the list ["a", "b", "c"] will be changed into ["c", "b", "a"]
    private static void ReversesList(List listOfLetters) {
        final int sizeList = listOfLetters.size();

        for (int i = 0; i < sizeList; i++) {
            listOfLetters.add(i, listOfLetters.get(listOfLetters.size() - 1));
            listOfLetters.remove(listOfLetters.size() - 1);
        }

    }
}