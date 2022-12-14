import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class OddIterator<T> implements Iterable<T>{
	
	 private final List<T> collection;
	 
	public OddIterator<T>(List<T> l1) {
		collection = l1;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

	
}

lass CustomIterator<> implements Iterator<> {
      
    // constructor
    CustomIterator<>(CustomDataStructure obj) {
        // initialize cursor
    }
      
    // Checks if the next element exists
    public boolean hasNext() {
    }
      
    // moves the cursor/iterator to next element
    public T next() {
    }
      
    // Used to remove an element. Implement only if needed
    public void remove() {
        // Default throws UnsupportedOperationException.
    }
}