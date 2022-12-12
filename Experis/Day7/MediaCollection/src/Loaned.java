public final class Loaned {
    private Media m_media;
    private String m_loanedTo;

    public Loaned(final Media media, final String loanedTo) {
        this.m_media = media;
        this.m_loanedTo = loanedTo;
    }

    public final Media getMedia() {
        return this.m_media;
    }

    public final String loanedTo() {
        return this.m_loanedTo;
    }
}
