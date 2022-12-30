import java.util.Comparator;

public final class AnyObjectTree<U, T extends Comparable<T>> implements Tree, Comparator {

    private final Comparator<U> m_comparator;
    private final ComparableTree<T> m_tree = new ComparableTree<T>();

    public AnyObjectTree(final Comparator<U> comparator) {
        m_comparator = comparator;


    }

    @Override
    public void add(Comparable item) {
        m_tree.add((T) item);

    }

    @Override
    public boolean contains(Comparable itemToFind) {
        throw new UnsupportedOperationException();
        // return false;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
        // return false;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
        // return 0;
    }

    @Override
    public void remove(Comparable itemToRemove) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Comparable get(Comparable itemToFind) {
        throw new UnsupportedOperationException();
        // return null;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return m_comparator.compare((U) o1, (U) o2);
    }
}