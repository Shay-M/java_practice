import java.util.Iterator;
import java.util.Optional;

// BinarySearchTree
public class ComparableTree<T extends Comparable<T>> implements Iterator<T>, Tree<T> { // implements Iterable
    // private static final Logger logger = Logger.getLogger(Tree.class.getCanonicalName());
    Optional<Node<T>> m_root = Optional.empty();
    private int count = 0;

    @Override
    public final void add(final T item) {
        if (m_root.isEmpty()) {
            m_root = Optional.of(new Node<T>(item));
        }
        else {
            m_root.get().add(item);
        }
        ++count;
    }

    @Override
    public final boolean contains(final T itemToFind) {
        return m_root.isPresent() && m_root.get().contains(itemToFind);
    }

    @Override
    public final boolean isEmpty() {
        return m_root.isEmpty();
    }

    @Override
    public final int size() {
        return count;
    }

    // remove a value from the tree
    @Override
    public final void remove(final T itemToRemove) {
        if (m_root.isEmpty()) {
            return;
        }
        if (m_root.get().getItem().equals(itemToRemove) && this.count == 1) {
            m_root = Optional.empty();
            return;
        }

        if (m_root.get().removingNode(itemToRemove)) {
            --count;
        }
    }


    // retrieves the value from the tree
    @Override
    public final T get(final T itemToFind) {
        //return m_root.isEmpty() ? null : m_root.get().getNode(itemToFind).get().getItem();
        return m_root.get().getNode(itemToFind).isPresent() ? m_root.get().getNode(itemToFind).get().getItem() : null;
    }


    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException();
        // return false;
    }

    @Override
    public T next() {
        throw new UnsupportedOperationException();
        // return null;
    }
}


