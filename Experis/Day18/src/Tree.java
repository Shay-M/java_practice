public interface Tree<T extends Comparable<T>> {
    void add(T item);

    boolean contains(T itemToFind);

    boolean isEmpty();

    int size();

    // remove a value from the tree
    void remove(T itemToRemove);

    // retrieves the value from the tree
    T get(T itemToFind);
}
