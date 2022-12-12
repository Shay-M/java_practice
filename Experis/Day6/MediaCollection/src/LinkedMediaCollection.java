public final class LinkedMediaCollection implements MediaCollection {
    private MediaNode head;
    private MediaNode tail;
    private int m_length = 0;


    @Override
    public void add(Media media) {
        MediaNode newNode = new MediaNode(media);
        tail.setNext(newNode);
        tail = newNode;

        if (head.getMedia() == null) {
            head = tail;
        }
        ++m_length;
    }

    @Override
    public void insert(Media media) {
        if (head == null) {
            head = new MediaNode(media);
        } else {
            MediaNode newNode = new MediaNode(media);
            newNode.setNext(head);
            head = newNode;
        }
        ++m_length;
    }

    @Override
    public void removeAt(int indexToRemove) {
        if (indexToRemove > count()) {//-1
            return;
        }

        MediaNode pointer = head;
        while (indexToRemove - 1 >= 0) {
            pointer = pointer.getNext().get();
            --indexToRemove;
        }


        --m_length;
    }

    @Override
    public Media at(int idx) {
        return null;
    }

    @Override
    public int count() {

        return m_length;
    }

    @Override
    public final MediaIterator iterator() {
        return new LinkedMediaIterator(head); // According to the diagram uml it does not contain no diamond arrow
    }


}