package Collection;

public final class ArrayCollectionSorted_long extends ArrayCollection_long {
    public ArrayCollectionSorted_long(int tableSize) {
        super(tableSize);
    }

    @Override
    public int add(final long key) {
        final int oldArrSize = count();
        int countIndex = 0;
        for (int i = 0; i < oldArrSize; i++) {
            if (this.getArray()[i] < key) {
                ++countIndex;
            }
        }
        final long[] newArray = new long[count() + 1];
        System.arraycopy(
                this.getArray(),
                0,
                newArray,
                0,
                countIndex);

        newArray[countIndex] = key;

        System.arraycopy(
                this.getArray(),
                countIndex,
                newArray,
                countIndex + 1,
                count() - countIndex);

        setArray(newArray);
        return countIndex;
    }
}
