import java.util.Optional;

public class Tree<T extends Comparable<T>> {
    // private static final Logger logger = Logger.getLogger(Tree.class.getCanonicalName());
    Optional<Node<T>> m_root = Optional.empty();
    private int count = 0;

    public final void add(final T date) {
        if (m_root.isEmpty()) {
            m_root = Optional.of(new Node<T>(date));
        } else {
            m_root.get().add(date);
        }
        ++count;
    }

    public final boolean contains(final T dateToFind) {
        return m_root.isEmpty() ? false : m_root.get().contains(dateToFind);
    }

    public final boolean isEmpty() {
        return m_root.isEmpty();
    }

    public final int size() {
        return count;
    }

    // remove a value from the tree
    public final void remove(final T date) {
        Optional<Node<T>> nodeToRemove = m_root.get().getNode(date);
        if (nodeToRemove.isPresent()) {

            --count;
        }

    }

    // retrieves the value from the tree
    public final T get(final T dateToFind) {
        //return m_root.isEmpty() ? null : m_root.get().getNode(dateToFind).get().getDate();
        return m_root.get().getNode(dateToFind).isPresent() ? m_root.get().getNode(dateToFind).get().getDate() : null;
    }
}


