public interface Collection {

    void add(Object object);

    void insert(Object object);

    void removeAt(int idx);

    Object at(int idx);

    int count();

    Iterator iterator();

}