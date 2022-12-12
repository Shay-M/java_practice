public final class ArrayCollection implements Collection {

    private Media[] m_array = new Media[0];
    //private final ArrayMediaIterator m_arrayMediaIterator = new ArrayMediaIterator(m_array);

    @Override
    public final void add(Media media) {
        final Media[] tempArray = new Media[count() + 1];
        System.arraycopy(m_array,
                0,
                tempArray,
                0,
                count());
        tempArray[count()] = media;
        m_array = tempArray;
        // m_arrayMediaIterator.update(m_array);
    }

    @Override
    public final void insert(Media media) { // like add but at beginning
        final Media[] newArray = new Media[count() + 1];
        newArray[0] = media;
        if (count() > 1) {
            System.arraycopy(
                    m_array,
                    0,
                    newArray,
                    1,
                    count());
            m_array = newArray;
        }
        //m_arrayMediaIterator.update(m_array);
    }

    @Override
    public final void removeAt(int indexToRemove) {
        if (indexToRemove > count()) {
            return;
        }
        final Media[] newArray = new Media[count() - 1];
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
    public final Media at(int indexToFind) {
        try {
            final Media returnedMedia = m_array[indexToFind];
            return returnedMedia;
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