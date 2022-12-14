// https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java
//Write an OddIterator that can be used to iterate over the odd-positioned elements in a List‏
// should output the strings Hello, How, you, today?

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());
	
	public static void main(String[] args) {
		final List<String> l1 = new LinkedList<String>();
		l1.add("Hello");
		l1.add("World");
		l1.add("How");
		l1.add("are");
		l1.add("you");
		l1.add("doing");
		l1.add("today?");
	
		final OddIterator<String> itr = new OddIterator<String>(l1);
		while (itr.hasNext()) {
	    	final String output = itr.next();
	    	logger.log(Level.INFO, output);
		}
				
	}
	
	
}