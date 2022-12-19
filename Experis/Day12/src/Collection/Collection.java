package Collection;

public interface Collection  {

    void add(long l);

    void insert(long l);

    void removeAt(int idx);

    long at(long idx);

    int count();

    Iterator iterator();

}