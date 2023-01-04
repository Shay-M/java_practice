package tasks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class TasksBundleOnDiskTest extends TasksShearedBundleTests {
//    TasksBundleOnDisk tasksBundleOnDisk = new TasksBundleOnDisk();

    @Override
    protected TasksBundle createTasksBundle() {
        return new TasksBundleOnDisk();
    }

    @BeforeEach
    void resatFolder() {
        TasksSystemFile.cleanUpFiles();
    }

}