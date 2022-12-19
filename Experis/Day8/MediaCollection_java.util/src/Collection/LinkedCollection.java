package Collection;

import java.util.Optional;

public final class LinkedCollection<T> implements Collection<T> {
    // private MediaNode m_head;
    private Optional<ObjNode<T>> m_head = Optional.empty();
    private Optional<ObjNode<T>> m_tail = Optional.empty();
    private int m_length = 0;


    @Override
    public void add(final T object) {
        final ObjNode<T> newNode = new ObjNode(object);

        if (m_head.isEmpty()) {
            m_head = Optional.of(newNode);
        } else {
            if (m_tail.isPresent()) {
                m_tail.get().setNext(newNode);
            }
        }
        m_tail = Optional.of(newNode);

        ++m_length;
    }

    @Override
    public void insert(final T object) {
        final ObjNode<T> newNode = new ObjNode(object);

        if (m_head.isEmpty()) {
            m_head = Optional.of(newNode);
            m_tail = Optional.of(newNode);
        } else {
            newNode.setNext(m_head.get());
            m_head = Optional.of(newNode);
        }
        ++m_length;
    }

    @Override
    public void removeAt(final int indexToRemove) {

        if (indexToRemove > count()) {
            return;
        }

        // Store head node
        Optional<ObjNode<T>> pointer = m_head;

        // If head needs to be removed
        if (indexToRemove == 0) {
            m_head = pointer.get().getNext(); // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int count = 0; pointer.isEmpty() && count < indexToRemove - 1; count++) {
            pointer = pointer.get().getNext();
        }
        // If position is more than number of nodes
        if (pointer.isEmpty() || pointer.get().getNext().isEmpty())
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        ObjNode<T> next = pointer.get().getNext().get().getNext().get();

        // Unlink the deleted node from list
        pointer.get().setNext(next);

        --m_length;
    }

    @Override
    public final T at(final int indexToFind) {
        //searchInLinked(idx);
        ObjNode<T> pointer = m_head.get();
        for (int count = 0; count < indexToFind; count++) {
            pointer = pointer.getNext().get();
        }

        return (T) pointer.getObject();
    }

    /*private searchInLinked (int indexToFind) {

    }*/

    /*private void removeNode(MediaNode MediaNodeToRemove) {

        MediaNodeToRemove.setNext(MediaNodeToRemove.getNext().get());

    }*/

    @Override
    public int count() {
        return m_length;
    }

    // According to the diagram uml it does not contain no diamond arrow
    @Override
    public final java.util.Iterator<T> iterator() {
        java.util.Iterator<T> iterator = new LinkedIterator<T>(m_head.get());
        return iterator;
    }


}