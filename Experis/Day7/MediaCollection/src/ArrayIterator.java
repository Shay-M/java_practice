public final class ArrayIterator implements Iterator {

    private Media[] m_array;
    private int courant = 0;

    public ArrayIterator(Media[] array) {
        m_array = array;
    }

    @Override
    public boolean hasNext() {
        return (courant < m_array.length);
    }

    @Override
    public Media next() {
        Media returnedMedia = m_array[courant];
        ++courant;
        return returnedMedia;
    }

}