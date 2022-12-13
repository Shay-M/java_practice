public final class ArrayCollection implements Collection {

    private Object[] m_array = new Object[0];
    //private final ArrayMediaIterator m_arrayMediaIterator = new ArrayMediaIterator(m_array);

    @Override
    public final void add(Object object) {
        final Object[] tempArray = new Object[count() + 1];
        System.arraycopy(m_array,
                0,
                tempArray,
                0,
                count());
        tempArray[count()] = object;
        m_array = tempArray;
        // m_arrayMediaIterator.update(m_array);
    }

    @Override
    public final void insert(Object object) { // like add but at beginning
        final Object[] newArray = new Object[count() + 1];
        newArray[0] = object;
        if (count() > 1) {
            System.arraycopy(
                    m_array,
                    0,
                    newArray,
                    1,
                    count());

        }
        m_array = newArray;
        //m_arrayMediaIterator.update(m_array);
    }

    @Override
    public final void removeAt(int indexToRemove) {
        if (indexToRemove > count()) {
            return;
        }
        final Object[] newArray = new Object[count() - 1];
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
        m_array = newArray;
        //m_arrayMediaIterator.update(m_array);
    }

    @Override
    public final Object at(int indexToFind) {

        try {
            final Object returnedObject = m_array[indexToFind]; // -1
            return returnedObject;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw ex; //todo
        }

    }

    @Override
    public final int count() {
        return m_array.length;
    }

    @Override
    public final Iterator iterator() {
        return new ArrayIterator(m_array); // According to the diagram uml it does not contain no diamond arrow
    }


}