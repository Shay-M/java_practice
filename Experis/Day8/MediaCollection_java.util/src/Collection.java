public interface Collection<T> extends Iterable<T> {

    void add(T t);

    void insert(T object);

    void removeAt(int idx);

    T at(int idx);

    int count();

    java.util.Iterator<T> iterator();

}