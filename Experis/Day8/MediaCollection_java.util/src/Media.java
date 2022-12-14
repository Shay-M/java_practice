public class Media {
    //final private int m_id;
    final private String m_title;
    final private String m_author;
    final private boolean m_isOriginal;
    protected boolean m_loaned;

    public Media(String title, String author, boolean isOriginal) {
        m_title = title;
        m_author = author;
        m_isOriginal = isOriginal;
    }

    public Media(String title, String author) {  //for book
        m_title = title;
        m_author = author;
        m_isOriginal = true;
    }

    public String getName() {
        return m_title;
    }

    public String getAuthor() {
        return m_author;
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


    public boolean getIsOriginal() {
        return m_isOriginal;
    }

    @Override
    public boolean equals(Object obj) {
        final Media mediaToCompare = (Media) obj;
        return mediaToCompare.getName().equals(this.getName()) && mediaToCompare.getAuthor().equals(this.getAuthor());
    }
}
