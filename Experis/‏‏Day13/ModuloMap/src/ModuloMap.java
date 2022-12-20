import Collection.ArrayCollectionSorted_long;
import Collection.Iterator;

import java.util.ArrayList;
import java.util.List;

public class ModuloMap<T> implements LongKeyMap<T> {
    // final private ArrayCollection_long m_keysArr;
    final private ArrayCollectionSorted_long m_keysArr;
    final private List<T> m_valueList;

    public ModuloMap(final int tableSize) {
        m_keysArr = new ArrayCollectionSorted_long(tableSize);
        m_valueList = new ArrayList<T>(tableSize);
    }

    @Override
    final public int size() {
        return m_keysArr.count();
    }

    @Override
    final public boolean isEmpty() {
        return m_valueList.isEmpty();
    }

    @Override
    final public T getValue(final long keyToFind) {
        final int moduloIdx = (int) (keyToFind % (m_valueList.size() + 1));
        Iterator keyIto = m_keysArr.iterator();
        java.util.Iterator<T> valueIto = m_valueList.iterator();
        while (keyIto.hasNext() && valueIto.hasNext()) {
            final long key = keyIto.next();
            final T value = valueIto.next();
            if (key == moduloIdx) {
                return value;
            }
        }
        throw new java.util.NoSuchElementException("Key not found!");
    }

    @Override
    final public boolean contains(final T value) { //XX
        //final int moduloIdx = (int) (keyToFind % (m_valueList.size() + 1));

//		try {
//			// T findedT = keyArr[(int)key];

//			return true;
//		}
//		catch (IndexOutOfBoundsException ex) {
//			return false;
//		}		
        return m_valueList.contains(value);
    }

    @Override
    final public void put(final long key, final T value) {
        final int moduloIdx = (int) (key % (m_valueList.size() + 1));
        int lastIndex = m_keysArr.add(moduloIdx);
        m_valueList.add(lastIndex, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LongKeyMap) {
            // https://stackoverflow.com/questions/16382887/how-to-implement-equals-method-for-generics-using-instanceof
            if (((LongKeyMap<?>) obj).size() == this.size()) {
                return true;
            }// need loop all
        }
        return false;
    }
}