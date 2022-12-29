package tasks;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class TasksBundleOnDisk implements TasksBundle, Iterable<Entry<Task, MutableState>> {

    // private final static TasksSystemFile tasksSystemFile = new TasksSystemFile(); when?

    @Override
    public final void add(final Task task) {
        if (task == null) {
            throw new IllegalArgumentException();
        }
        try {
            TasksSystemFile.createFile(task);
        } catch (FileAlreadyExistsException e) {
            throw new TaskAlreadyExistsException(task);
        }
    }

    @Override
    public final Iterator<Entry<Task, MutableState>> iterator() {
        final Map<Task, MutableState> m_tasks = new HashMap<>();
        //todo
        final List<Path> listOfPathFiles = TasksSystemFile.listOfFileInRoot();

        for (Path filePath : listOfPathFiles) {
            m_tasks.put(createTaskFromPath(filePath), createMutableStateFromPath(filePath));
        }

        return m_tasks.entrySet().iterator();
    }

    private MutableState createMutableStateFromPath(final Path filePath) {
        final boolean completedTaskStateFromFile = Boolean.parseBoolean(TasksSystemFile.readMutableStateFromFileTasks(
                filePath.getFileName().toString(),
                TasksSystemFile.COMPLETED_LOCATION_IN_LIST
        ));
        MutableState mutableState = new MutableState();
        mutableState.setCompleted(completedTaskStateFromFile);

        return mutableState;
    }

    private Task createTaskFromPath(final Path filePath) {
        final String dateTimeFromFile = TasksSystemFile.readMutableStateFromFileTasks(
                filePath.getFileName().toString(),
                TasksSystemFile.DATE_AND_TIME_LOCATION_IN_LIST
        );
        final LocalDateTime endDateTime = LocalDateTime.parse(
                dateTimeFromFile,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME
        );
        return new Task(filePath.getFileName().toString(), endDateTime);
    }

    @Override
    public final boolean isEmpty() {
        return TasksSystemFile.listOfFileInRoot().size() == 0;
    }

    @Override
    public final int size() {
        return (int) TasksSystemFile.listOfFileInRoot().size();
    }

    @Override
    public final MutableState getState(final Task task) {

        final MutableStateOnDisk mutableStateFromFile = new MutableStateOnDisk(task);
        //Path taskFilePath = tasksSystemFile.pathOfFile(task.getName());

        final boolean isTaskFromFileCompleted = Boolean.parseBoolean(TasksSystemFile.readMutableStateFromFileTasks(
                task.getName(),
                TasksSystemFile.COMPLETED_LOCATION_IN_LIST
        ));
        mutableStateFromFile.setCompleted(isTaskFromFileCompleted);

        return mutableStateFromFile;
        //        if (!m_tasks.containsKey(task)) {
//            throw new IllegalArgumentException("task not found: " + task.toString());
//        }

    }
}
