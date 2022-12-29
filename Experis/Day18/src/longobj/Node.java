package longobj;

import java.util.Optional;

public final class Node implements Comparable<Long> {

    private Optional<Node> m_left = Optional.empty();
    private Optional<Node> m_right = Optional.empty();
    private final Long m_date;

    public Node(final Long date) {
        m_date = date;
    }


    @Override
    public int compareTo(final Long dateFromOther) {
        return m_date.compareTo(dateFromOther);
    }

    public final void add(final Long objToAdd) {
        if (this.compareTo(objToAdd) < 0) { // ==?
            if (m_left.isEmpty()) {
                m_left = Optional.of(new Node(objToAdd));
            } else {
                m_left.get().add(objToAdd);
            }
        } else {
            if (m_right.isEmpty()) {
                m_right = Optional.of(new Node(objToAdd));
            } else {
                m_right.get().add(objToAdd);
            }
        }
    }

    /*public final void add(final Long objToAdd) {
        if (this.compareTo(objToAdd) > 0) { // this > date
            addToNode(m_left, objToAdd);
        } else {
            addToNode(m_right, objToAdd);
        }
    }

    private void addToNode(Optional<Node> node, final Long objToAdd) {
        if (node.isEmpty()) {
            node = Optional.of(new Node(objToAdd));
        } else {
            node.get().add(objToAdd);
        }
    }*/

    public final boolean contains(final Long dateToFind) {
        if (m_date.equals(dateToFind)) { //hmm
            return true;
        } else if (this.compareTo(dateToFind) > 0 && m_left.isPresent()) {
            return m_left.get().contains(dateToFind);
        } else if (this.compareTo(dateToFind) > 0 && m_right.isPresent()) {
            return m_right.get().contains(dateToFind);
        }
        return false;
    }


}
