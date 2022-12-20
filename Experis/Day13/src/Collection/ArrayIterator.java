package Collection;

public final class ArrayIterator implements Iterator {

    private final Object[] m_array;
    private int courant = 0;

    public ArrayIterator(Object[] array) {
        m_array = array;
    }

    @Override
    public final boolean hasNext() {
        return (courant < m_array.length);
    }

    @Override
    public final Object next() {
        Object returnedObject = m_array[courant];
        ++courant;
        return returnedObject;
    }

}