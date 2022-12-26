package tasks;

import java.nio.file.FileAlreadyExistsException;
import java.util.Iterator;
import java.util.Map;

public final class TasksBundleOnDisk implements TasksBundle {

    private final static TasksSystemFile tasksSystemFile = new TasksSystemFile();

    @Override
    public final void add(Task task) {
        try {
            tasksSystemFile.createFile(task);
        } catch (FileAlreadyExistsException e) {
            throw new TaskAlreadyExistsException(task);
        }
    }

    @Override
    public final Iterator<Map.Entry<Task, MutableState>> iterator() {
        throw new UnsupportedOperationException();
        //return null;
    }

    @Override
    public final boolean isEmpty() {
        return tasksSystemFile.numberOfFileInRoot() == 0;
    }

    @Override
    public final int size() {
        return tasksSystemFile.numberOfFileInRoot();
    }

    @Override
    public final MutableState getState(Task task) {
        throw new UnsupportedOperationException();
        //return null;
    }
}
