package Collection;


public final class ArrayCollection_long implements Collection {
    private long[] m_array;
    public ArrayCollection_long() {
        this.m_array = new long[0];
    }

    //private long[] m_array = long[] new Object[0];


    @Override
    public final void add(final long key) {
        final long[] newArray = new long[count() + 1];
        System.arraycopy(m_array,
                0,
                newArray,
                0,
                count());
        newArray[count()] = key;
        m_array = newArray;
    }

    @Override
    public final void insert(final long key) { // like add but at beginning
        final long[] newArray = new long[count() + 1];
        newArray[0] = key;
        if (count() > 0) {
            System.arraycopy(
                    m_array,
                    0,
                    newArray,
                    1,
                    count());
        }
        m_array = newArray;
    }

    @Override
    public final void removeAt(final int indexToRemove) {
        if (indexToRemove > count()) {
            return;
        }
        final long[] newArray = new long[count() - 1];
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
        m_array = (long[]) newArray;
    }

    @Override
    public final long at(final long indexToFind) {
        try {
            final long returnedObject = m_array[(int) indexToFind]; // -1
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
    public Iterator iterator() {
        return new ArrayIterator(m_array);
    }
}