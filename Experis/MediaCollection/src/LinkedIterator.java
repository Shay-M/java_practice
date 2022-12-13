import java.util.Optional;

public final class LinkedIterator implements Iterator {

    // private MediaNode m_head;
    private Optional<ObjNode> m_head;
    //private MediaNode pointer;

    public LinkedIterator(ObjNode objNode) {
        m_head = Optional.of(objNode);
        //pointer = m_head;
    }

    @Override
    public boolean hasNext() {
        return m_head.isPresent();
    }

    @Override
    public Object next() {

        Object returnedObject = m_head.get().getObject();

        if (m_head.get().getNext().isPresent()) {
            m_head = m_head.get().getNext();
        } else {
            m_head = Optional.empty();
        }

        return returnedObject;
    }


}