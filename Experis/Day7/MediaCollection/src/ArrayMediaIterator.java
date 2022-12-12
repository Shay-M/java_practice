public final class ArrayMediaIterator implements MediaIterator {

    private Media[] m_array; //final?
    private int courant = 0;

    public ArrayMediaIterator(Media[] array) {
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