public class Media {


    final private String m_author;
    //final private int m_id;
    final private String m_title;
    final private boolean m_isOriginal;

    protected boolean m_loaned;

    public Media(String title, String author, boolean isOriginal) {
        m_title = title;
        m_author = author;
        m_isOriginal = isOriginal;
    }

    public String getName() {
        return m_title;
    }

    /*public int getId() {
        return m_id;
    }

    public void setId(int id) {
        m_id = id;
    }*/

    public boolean getLoaned() {
        return m_loaned;
    }

    public void setLoaned(boolean loaned) {
        m_loaned = loaned;
    }

    public boolean getIsOriginal() {
        return m_isOriginal;
    }
}
