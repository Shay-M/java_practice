public class KeyAndDate<E> {
    final private long m_key;

    final private E m_date;

    public KeyAndDate(long key, E date) {
        m_key = key;
        m_date = date;
    }

    public long getKey() {
        return m_key;
    }

    public E getDate() {
        return m_date;
    }


}
