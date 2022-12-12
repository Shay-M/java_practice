import java.util.Optional;

public final class LinkedCollection implements Collection {
    // private MediaNode m_head;
    private Optional<MediaNode> m_head = Optional.empty();
    private Optional<MediaNode> m_tail = Optional.empty();
    private int m_length = 0;


    @Override
    public void add(Media media) {
        final MediaNode newNode = new MediaNode(media);

        if (m_head.isEmpty()) {
            m_head = Optional.of(newNode);
            m_tail = Optional.of(newNode);
        } else {
            if (m_tail.isPresent()) {
                m_tail.get().setNext(newNode);
            }
            m_tail = Optional.of(newNode);
        }

        ++m_length;
    }

    @Override
    public void insert(Media media) {
        final MediaNode newNode = new MediaNode(media);

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
    public void removeAt(int indexToRemove) {

        if (indexToRemove > count()) {
            return;
        }

        // Store head node
        Optional<MediaNode> pointer = m_head;

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
        MediaNode next = pointer.get().getNext().get().getNext().get();

        // Unlink the deleted node from list
        pointer.get().setNext(next);

        --m_length;
    }

    @Override
    public Media at(int indexToFind) {
        //searchInLinked(idx);
        MediaNode pointer = m_head.get();
        for (int count = 0; count < indexToFind; count++) {
            pointer = pointer.getNext().get();
        }

        return pointer.getMedia();
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

    @Override
    public final Iterator iterator() {
        return new LinkedIterator(m_head.get()); // According to the diagram uml it does not contain no diamond arrow
    }


}