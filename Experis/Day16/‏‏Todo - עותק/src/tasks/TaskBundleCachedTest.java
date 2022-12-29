package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskBundleCachedTest extends TasksShearedBundleTests {
    final TaskBundleCached taskBundleCached = new TaskBundleCached();

    @Override
    protected TasksBundle createTasksBundle() {
//        return taskBundleCached;
        return new TaskBundleCached();

    }

    @BeforeEach
    void resatFolder() {
        TasksSystemFile.cleanUpFiles();
    }

    @Test
    void taskOnMemoryReadFromDisk() {
        final TasksBundleOnDisk tasksBundleOnDisk = new TasksBundleOnDisk();
        taskBundleCached.add(FIXING_TASK_1);
        assertTrue(tasksBundleOnDisk.iterator().hasNext());
    }


}