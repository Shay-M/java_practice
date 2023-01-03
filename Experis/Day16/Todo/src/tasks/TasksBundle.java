package tasks;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public interface TasksBundle extends Iterable<Map.Entry<Task, MutableState>> {

    void add(final Task task);

    Iterator<Map.Entry<Task, MutableState>> iterator();

    boolean isEmpty();

    int size();

    MutableState getState(Task task);

}
