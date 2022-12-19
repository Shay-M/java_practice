package Collection;

import java.util.Optional;

public final class LinkedIterator<T> implements java.util.Iterator<T> {

    // private MediaNode m_head;
    private Optional<ObjNode<T>> m_head;
    //private MediaNode pointer;

    public LinkedIterator(ObjNode<T> objNode) {
        m_head = Optional.of(objNode);
        //pointer = m_head;
    }

    @Override
    public boolean hasNext() {
        return m_head.isPresent();
    }

    @Override
    public final T next() {

        T returnedObject = m_head.get().getObject();

        if (m_head.get().getNext().isPresent()) {
            m_head = m_head.get().getNext();
        } else {
            m_head = Optional.empty();
        }

        return returnedObject;
    }


}