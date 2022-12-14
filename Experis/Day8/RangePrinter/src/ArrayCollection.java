public final class ArrayCollection<T> implements Collection<T> {

    //private final ArrayMediaIterator m_arrayMediaIterator = new ArrayMediaIterator(m_array);
    // private Object[] m_array = new Object[0];
    private T[] m_array = (T[]) new Object[0];

    @Override
    public final void add(final T object) {
        final T[] tempArray = (T[]) new Object[count() + 1];
        System.arraycopy(m_array,
                0,
                tempArray,
                0,
                count());
        tempArray[count()] = (T) object;
        m_array = (T[]) tempArray;
        // m_arrayMediaIterator.update(m_array);
    }

    @Override
    public final void insert(final T object) { // like add but at beginning
        final T[] newArray = (T[]) new Object[count() + 1];
        newArray[0] = (T) object;
        if (count() > 0) {
            System.arraycopy(
                    m_array,
                    0,
                    newArray,
                    1,
                    count());

        }
        m_array = (T[]) newArray;
        //m_arrayMediaIterator.update(m_array);
    }

    @Override
    public final void removeAt(final int indexToRemove) {
        if (indexToRemove > count()) {
            return;
        }
        final T[] newArray = (T[]) new Object[count() - 1];
        System.arraycopy(m_array,
                0,
                newArray,
                0,
                indexToRemove);

        System.arraycopy(m_array,
                indexToRemove + 1,
                newArray,
                indexToRemove,
                count() - indexToRemove - 1);
        m_array = (T[]) newArray;
        //m_arrayMediaIterator.update(m_array);
    }

    @Override
    public final T at(final int indexToFind) {
        try {
            final T returnedObject = (T) m_array[indexToFind]; // -1
            return (T) returnedObject;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw ex; //todo
        }

    }

    @Override
    public final int count() {
        return m_array.length;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        java.util.Iterator<T> iterator = new ArrayIterator<T>(m_array);
        return iterator;
    }


}