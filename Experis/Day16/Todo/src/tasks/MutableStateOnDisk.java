package tasks;

public class MutableStateOnDisk extends MutableState {
    final private Task m_task;

    public MutableStateOnDisk(final Task task) {
        m_task = task;
    }

    @Override
    public void setCompleted(final boolean isCompleted) {
        TasksSystemFile.writerToFiles("", m_task, isCompleted);
        setIsCompleted(isCompleted);
    }
}
