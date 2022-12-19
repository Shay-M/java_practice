package Collection;

public final class ArrayIterator implements Iterator {

    private final long[] m_array;
    private int courant = 0;

    public ArrayIterator(long[] array) {
        m_array = array;
    }

    @Override
    public final boolean hasNext() {
        return (courant < m_array.length);
    }

    @Override
    public final long next() {
        long returnedObject = m_array[courant];
        ++courant;
        return returnedObject;
    }

}