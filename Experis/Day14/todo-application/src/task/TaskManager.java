package task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {


    private final List<Task> taskList = new ArrayList<Task>();

    public List<Task> getTaskList() {
        return taskList;
    }

    public final void add(final String taskName, final LocalDateTime endTime) {
        final Task task = new Task(taskName, endTime);
        taskList.add(task);
    }

    public final void Delete(final String taskName) {
        taskList.removeIf(task -> task.getName().equals(taskName));
    }

    public final void Completed(final String taskName) {
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                task.setDone(true); // todo
            }
        }
    }

    public final void NotCompleted(final String taskName) {
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                task.setDone(false); // todo
            }
        }
    }
}
