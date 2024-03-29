public final class ArrayIterator<T> implements Iterator<T> {

    private T[] m_array;
    private int courant = 0;

    public ArrayIterator(T[] array) {
        m_array = array;
    }

    @Override
    public boolean hasNext() {
        return (courant < m_array.length);
    }

    @Override
    public T next() {
        T returnedObject = m_array[courant];
        ++courant;
        return returnedObject;
    }

}