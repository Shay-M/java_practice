package tasks;

class TasksBundleInMemoryTest extends TasksShearedBundleTests {

    @Override
    protected TasksBundle createTasksBundle() {
        return new TasksBundleInMemory();
    }
}