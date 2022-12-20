package Collection;

import java.util.Iterator;

public interface Collection extends Iterable {

    int add(Object o);

    void insert(Object o);

    void removeAt(int idx);

    Object at(int indexToFind);

    int count();

    Iterator iterator();

}