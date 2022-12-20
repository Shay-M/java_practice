package Collection;

public final class ArrayCollectionSorted_long extends ArrayCollection_long {
    @Override
    public int add(final long key) {
        final int oldArrSize = count();
        int countIndex = 0;
        for (int i = 0; i < oldArrSize; i++) {
            if (m_array[i] < key) {
                ++countIndex;
            }
        }
        final long[] newArray = new long[count() + 1];
        System.arraycopy(
                m_array,
                0,
                newArray,
                0,
                countIndex);

        newArray[countIndex] = key;

        System.arraycopy(
                m_array,
                countIndex,
                newArray,
                countIndex + 1,
                count() - countIndex);

        m_array = newArray;
        return countIndex;
    }
}
