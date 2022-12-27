package tasks;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TaskBundleCachedTest extends TasksShearedBundleTests {

    @Override
    protected TasksBundle createTasksBundle() {
        return new TaskBundleCached();
    }

    @BeforeEach
    void resatFolder() {
        TasksSystemFile.cleanUpFiles();
    }
}