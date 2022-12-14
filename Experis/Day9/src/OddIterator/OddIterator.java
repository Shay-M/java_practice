package OddIterator;

import java.util.Iterator;
import java.util.List;


public class OddIterator<T> implements Iterator<T> {

    private final List<T> collection;
    private int index = 0;


    public OddIterator(List<T> l1) {
        collection = l1;
    }

    @Override
    public boolean hasNext() {
        return (collection.size() > index + 1);
    }

    @Override
    public T next() {
        return collection.get(index++);
    }


}
