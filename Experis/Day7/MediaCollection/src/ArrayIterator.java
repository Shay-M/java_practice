public final class ArrayIterator implements Iterator {

    private Object[] m_array;
    private int courant = 0;

    public ArrayIterator(Object[] array) {
        m_array = array;
    }

    @Override
    public boolean hasNext() {
        return (courant < m_array.length);
    }

    @Override
    public Object next() {
        Object returnedObject = m_array[courant];
        ++courant;
        return returnedObject;
    }

}