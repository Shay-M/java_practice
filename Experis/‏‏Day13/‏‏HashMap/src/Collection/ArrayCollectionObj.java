package Collection;


import java.util.Iterator;

public class ArrayCollectionObj implements Collection {
    private int m_tableSize;

    private Object[] m_array;

    public ArrayCollectionObj(int tableSize) {
        this.m_array = new Object[m_tableSize];
        m_tableSize = tableSize;
    }

    protected Object[] getArray() {
        return m_array;
    }

    public void setArray(Object[] m_array) {
        this.m_array = m_array;
    }

    @Override
    public int add(final Object key) {
        final Object[] newArray = new Object[count() + 1];
        System.arraycopy(m_array,
                0,
                newArray,
                0,
                count());
        newArray[count()] = key; // add to last
        m_array = newArray;

        return count() - 1;
    }

    @Override
    public final void insert(final Object key) { // like add but at beginning
        final Object[] newArray = new Object[count() + 1];
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
    }

    @Override
    public final Object at(final int indexToFind) {
        try {
            final Object returnedObject = m_array[(int) indexToFind]; // -1
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