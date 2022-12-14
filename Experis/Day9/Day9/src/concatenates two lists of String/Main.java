import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Iterator;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());
	
	public static void main(String[] args) {
				
		final LinkedList<String> listOfLatters = new LinkedList<String>();
		listOfLatters.add("a");
		listOfLatters.add("b");
		listOfLatters.add("c");
		
		final LinkedList<String> listOfNumbers = new LinkedList<String>();
		listOfNumbers.add("1");
		listOfNumbers.add("2");
		listOfNumbers.add("3");
		
		final ArrayList<String> arrayOfLatters = new ArrayList<String>();
		arrayOfLatters.add("a");
		arrayOfLatters.add("b");
		arrayOfLatters.add("c");
		
		final ArrayList<String> arrayOfNumbers = new ArrayList<String>();
		arrayOfNumbers.add("1");
		arrayOfNumbers.add("2");
		arrayOfNumbers.add("3");
		
		//- The function DOES NOT CHANGE the lists it receives as function arguments.
		//- The function returns a new list that contains all the elements of the two lists passed as arguments.
		//- The function should have a complexity O(N) no matter if the List arguments are actually of an ArrayList and a LinkedList.
		//- The returned list is a LinkedList.

		//Why not return an ArrayList?
		//In ArrayList add() is of complexity O(N), if we perform add() N times -> O(N*N) -> O(N^2)

		//https://www.prepbytes.com/blog/java/linkedlist-addall-method-in-java/
		
		logger.log(Level.INFO, "1. " + CombinesListsOfString(listOfLatters , listOfNumbers));
		logger.log(Level.INFO, "2. " + CombinesListsOfString(arrayOfLatters , arrayOfNumbers));
		logger.log(Level.INFO, "3. " + CombinesListsOfStringAlternatingly(listOfLatters , listOfNumbers));
		logger.log(Level.INFO, "4. " + CombinesListsOfStringAlternatingly(arrayOfLatters , arrayOfNumbers));
	
	}
	
	// e.g. ["a","b","c"], ["1","2","3"] → ["a","b","c","1","2","3"]‏
	private final static LinkedList<String> CombinesListsOfString (Collection<String> listOfLatters , Collection<String> listOfNumbers) {
		final LinkedList<String> newList = new LinkedList<String>(listOfLatters); // n
		newList.addAll(listOfNumbers); //n
		return newList;
	}
	// e.g. ["a","b","c"], ["1","2","3"] → ["a","1","b","2","c","3"]‏
	private final static LinkedList<String> CombinesListsOfStringAlternatingly (Collection<String> listOfLatters , Collection<String> listOfNumbers) {
		final LinkedList<String> newList = new LinkedList<String>(); //1
		final Iterator<String> itl = listOfLatters.iterator(); //1
		final Iterator<String> itn = listOfNumbers.iterator(); //1
		
		while ( itl.hasNext() && itn.hasNext() ) {
			newList.add(itl.next()); //1
			newList.add(itn.next()); //1
		} //n
		
		while (itl.hasNext()) {
			newList.add(itl.next());
		} //n	
		
		while (itn.hasNext()) { 
			newList.add(itn.next()); 
		} //n
		
		return newList;
	}
	
}