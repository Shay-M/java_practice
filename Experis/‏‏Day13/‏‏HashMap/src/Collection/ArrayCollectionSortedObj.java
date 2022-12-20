package Collection;

public final class ArrayCollectionSortedObj extends ArrayCollectionObj {
    public ArrayCollectionSortedObj(int tableSize) {
        super(tableSize);
    }

    @Override
    public int add(final Object key) {
        final int oldArrSize = count();
        int countIndex = 0;
        for (int i = 0; i < oldArrSize; i++) {
            if (this.getArray()[i].hashCode() < key.hashCode()) {
                ++countIndex;
            }
        }
        final Object[] newArray = new Object[count() + 1];
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
