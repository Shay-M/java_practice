public interface Collection<T> {

    void add(T t);

    void insert(T object);

    void removeAt(int idx);

    T at(int idx);

    int count();

    Iterator<T> iterator();

}