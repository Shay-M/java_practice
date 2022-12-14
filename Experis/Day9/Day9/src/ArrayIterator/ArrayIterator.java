package ArrayIterator;
/*Arrays are not Iterable (they do not have an iterator() method).
We would like to have an Iterator for arrays:

String[] arr = { "Hello", "There" };

Iterator<String> itr = new ArrayIterator(arr);
while (itr.hasNext()) {
String str = itr.next();
logger.log(Level.INFO, str);
}

Write the ArrayIterator class.*/

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int index;
    private T[] m_arr;

    public ArrayIterator(T[] arr) {
        m_arr = arr;
        index = 0;
    }

    @Override
    public final boolean hasNext() {
        return (index < m_arr.length);
    }

    @Override
    public final T next() {
        T returnedObject = m_arr[index];
        ++index;
        return returnedObject;
    }
}
