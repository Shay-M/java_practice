public final class ArrayIterator<T> implements java.util.Iterator<T> {

    private final T[] m_array;
    private int courant = 0;

    public ArrayIterator(T[] array) {
        m_array = array;
    }

    @Override
    public final boolean hasNext() {
        return (courant < m_array.length);
    }

    @Override
    public final T next() {
        T returnedObject = m_array[courant];
        ++courant;
        return returnedObject;
    }

}