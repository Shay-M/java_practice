import java.util.Comparator;

public final class AnyObjectTree<U> implements Tree, Comparator {

    private final Comparator<U> m_comparator;
    private final ComparableTree<U> m_tree = new ComparableTree<U>();

    public AnyObjectTree(final Comparator<U> comparator) {
        m_comparator = comparator;
    }

    @Override
    public void add(Comparable item) {
        m_tree.add((U) item);

    }

    @Override
    public boolean contains(Comparable itemToFind) {
        return m_tree.contains((U) itemToFind);
    }

    @Override
    public boolean isEmpty() {
        return m_tree.isEmpty();
    }

    @Override
    public int size() {
        return m_tree.size();
    }

    @Override
    public void remove(Comparable itemToRemove) {
        m_tree.remove((U) itemToRemove);

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