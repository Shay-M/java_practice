package tasks;

import java.nio.file.FileAlreadyExistsException;
import java.util.Iterator;
import java.util.Map;

public final class TasksBundleOnDisk implements TasksBundle {

    private final static TasksSystemFile tasksSystemFile = new TasksSystemFile();

    @Override
    public final void add(final Task task) {
        if (task == null) {
            throw new IllegalArgumentException();
        }
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
        return tasksSystemFile.listOfFileInRoot().size() == 0;
    }

    @Override
    public final int size() {
        return (int) tasksSystemFile.listOfFileInRoot().size();
    }

    @Override
    public final MutableState getState(final Task task) {

        final MutableState mutableStateFromFile = new MutableState();
        mutableStateFromFile.setCompleted(tasksSystemFile.readMutableStateFromFileTasks(task));

//        if (!m_tasks.containsKey(task)) {
//            throw new IllegalArgumentException("task not found: " + task.toString());
//        }

        return mutableStateFromFile;
    }
}
