import java.util.Optional;

public final class Node<T extends Comparable<T>> implements Comparable<T> { // , Iterator<T>

    private Optional<Node<T>> m_left = Optional.empty();
    private Optional<Node<T>> m_right = Optional.empty();
    //private final Optional<T> m_item;
    private T m_item;

    public Node(final T item) {
        m_item = item;
    }

    public T getItem() {
        return m_item;
    }

    @Override
    public int compareTo(final T itemFromOther) {
        // return ((Comparable) m_item).compareTo(itemFromOther); with not public final class Node<T extends Comparable<T>> implements Comparable<T> {
        return m_item.compareTo(itemFromOther);
    }

    public void add(final T objToAdd) {
        if (this.compareTo(objToAdd) > 0) {
            if (m_left.isEmpty()) {
                m_left = Optional.of(new Node<T>(objToAdd));
            }
            else {
                m_left.get().add(objToAdd);
            }
        }
        else {
            if (m_right.isEmpty()) {
                m_right = Optional.of(new Node<T>(objToAdd));
            }
            else {
                m_right.get().add(objToAdd);
            }
        }
    }

   /* -ask
    public final void add(final T objToAdd) {
        if (this.compareTo(objToAdd) > 0) { // this > item
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


    public boolean contains(final T itemToFind) {
        return getNode(itemToFind).isPresent();
//        if (m_item.equals(itemToFind)) { //hmm
//            return true;
//        } else {
//            final int compareResult = this.compareTo(itemToFind);
//            if (compareResult > 0 && m_left.isPresent()) {
//                return m_left.get().contains(itemToFind);
//            } else if (compareResult < 0 && m_right.isPresent()) {
//                return m_right.get().contains(itemToFind);
//            }
//        }
//        return false;
    }

    /*
    public final Optional<Object> getitem(final T itemToFind) {

        if (m_item.equals(itemToFind)) {
            return Optional.of(m_item);
        } else {
            final int compareResult = this.compareTo(itemToFind);
            if (compareResult < 0 && m_left.isPresent()) {
                return m_left.get().getitem(itemToFind);
            } else if (compareResult > 0 && m_right.isPresent()) {
                return m_right.get().getitem(itemToFind);
            }
        }
        return Optional.empty();
    }*/

    public Optional<Node<T>> getNode(final T itemToFind) {
        if (m_item.equals(itemToFind)) {
            return Optional.of(this);
        }
        else {
            final int compareResult = this.compareTo(itemToFind);
            if (compareResult > 0 && m_left.isPresent()) {
                return m_left.get().getNode(itemToFind);
            }
            else if (compareResult < 0 && m_right.isPresent()) {
                return m_right.get().getNode(itemToFind);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        final T convertObj = (T) obj;
        return this.m_item.equals(convertObj);
    }

    public boolean removingNode(final T itemToRemove) {
        Optional<Node<T>> nodeToRemove = getNode(itemToRemove);
        if (nodeToRemove.isPresent()) {
            Optional<Node<T>> follower;
            // locatingFollower {
            Optional<Node<T>> pointer = nodeToRemove;
            assert nodeToRemove != null;
            Optional<Node<T>> pointerSlow = pointer;
            if (nodeToRemove.get().m_left.isPresent()) {
                pointer = nodeToRemove.get().m_left;
                while (pointer.isPresent()) {
                    pointerSlow = pointer;
                    pointer = pointer.get().m_right;
                }
                follower = pointerSlow;
            }
            else if (nodeToRemove.get().m_right.isPresent()) {
                follower = nodeToRemove.get().m_right;
            }
            else {
                follower = pointerSlow;
            }
            // }
            nodeToRemove.get().m_item = follower.get().m_item;
            pointerSlow.get().m_right = Optional.empty();
            return true;
        }
        else {
            return false;
        }
    }

    /*private Optional<Node<T>> locatingFollower(final Node<T> nodeToRemove) {
        Optional<Node<T>> pointer = Optional.ofNullable(nodeToRemove);
        assert nodeToRemove != null;
        Optional<Node<T>> pointerSlow = pointer;
        if (nodeToRemove.m_left.isPresent()) {
            pointer = nodeToRemove.m_left;
            while (pointer.get().m_left.isPresent()) {
                pointerSlow = pointer;
                pointer = pointer.get().m_right;
            }
            return pointerSlow;
        }
        else if (nodeToRemove.m_right.isPresent()) {
            pointer = nodeToRemove.m_right;
            return pointerSlow;
        }
        else {
            return pointer;
        }

    }*/


}
