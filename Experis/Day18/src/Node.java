import java.util.Optional;

public final class Node<T extends Comparable<T>> implements Comparable<T> {

    private Optional<Node<T>> m_left = Optional.empty();
    private Optional<Node<T>> m_right = Optional.empty();

    //private final Optional<T> m_date;
    private final T m_date;

    public Node(final T date) {
        m_date = date;
    }

    public T getDate() {
        return m_date;
    }


    @Override
    public int compareTo(final T dateFromOther) {
        // return ((Comparable) m_date).compareTo(dateFromOther); with not public final class Node<T extends Comparable<T>> implements Comparable<T> {
        return m_date.compareTo(dateFromOther);
    }

    public void add(final T objToAdd) {
        if (this.compareTo(objToAdd) < 0) {
            if (m_left.isEmpty()) {
                m_left = Optional.of(new Node<T>(objToAdd));
            } else {
                m_left.get().add(objToAdd);
            }
        } else {
            if (m_right.isEmpty()) {
                m_right = Optional.of(new Node<T>(objToAdd));
            } else {
                m_right.get().add(objToAdd);
            }
        }
    }

   /* -ask
    public final void add(final T objToAdd) {
        if (this.compareTo(objToAdd) > 0) { // this > date
            addToNode(m_left, objToAdd);
        } else {
            addToNode(m_right, objToAdd);
        }
    }

    private void addToNode(Optional<Node> node, final T objToAdd) {
        if (node.isEmpty()) {
            node = Optional.of(new Node(objToAdd));
        } else {
            node.get().add(objToAdd);
        }
    }*/


    public boolean contains(final T dateToFind) {
        return getNode(dateToFind).isPresent();
//        if (m_date.equals(dateToFind)) { //hmm
//            return true;
//        } else {
//            final int compareResult = this.compareTo(dateToFind);
//            if (compareResult > 0 && m_left.isPresent()) {
//                return m_left.get().contains(dateToFind);
//            } else if (compareResult < 0 && m_right.isPresent()) {
//                return m_right.get().contains(dateToFind);
//            }
//        }
//        return false;
    }

    /*
    public final Optional<Object> getDate(final T dateToFind) {

        if (m_date.equals(dateToFind)) {
            return Optional.of(m_date);
        } else {
            final int compareResult = this.compareTo(dateToFind);
            if (compareResult < 0 && m_left.isPresent()) {
                return m_left.get().getDate(dateToFind);
            } else if (compareResult > 0 && m_right.isPresent()) {
                return m_right.get().getDate(dateToFind);
            }
        }
        return Optional.empty();
    }*/

    public Optional<Node<T>> getNode(final T dateToFind) {
        if (m_date.equals(dateToFind)) {
            return Optional.of(this);
        } else {
            final int compareResult = this.compareTo(dateToFind);
            if (compareResult > 0 && m_right.isPresent()) {
                return m_right.get().getNode(dateToFind);
            } else if (compareResult < 0 && m_left.isPresent()) {
                return m_left.get().getNode(dateToFind);
            }
        }
        return Optional.empty();
    }


}
