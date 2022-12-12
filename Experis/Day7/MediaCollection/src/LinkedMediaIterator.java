import java.util.Optional;

public final class LinkedMediaIterator implements MediaIterator {

    // private MediaNode m_head;
    private Optional<MediaNode> m_head;
    //private MediaNode pointer;

    public LinkedMediaIterator(MediaNode mediaNode) {
        m_head = Optional.of(mediaNode);
        //pointer = m_head;
    }

    @Override
    public boolean hasNext() {
        return m_head.isPresent();
    }

    @Override
    public Media next() {

        Media returnedMedia = m_head.get().getMedia();

        if (m_head.get().getNext().isPresent()) {
            m_head = m_head.get().getNext();
        } else {
            m_head = Optional.empty();
        }

        return returnedMedia;
    }


}