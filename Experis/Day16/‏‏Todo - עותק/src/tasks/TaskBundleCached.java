package tasks;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public final class TaskBundleCached implements TasksBundle {
    private final TasksBundleOnDisk m_onDisk_slow = new TasksBundleOnDisk();
    //    private final TasksBundleInMemory m_inMemory = new TasksBundleInMemory();
    private Optional<TasksBundleInMemory> mOpt_inMemory_fast = Optional.empty();

    private void initializeInMemoryFromDisk() {
        mOpt_inMemory_fast = Optional.of(new TasksBundleInMemory());
        final TasksBundleInMemory m_inMemory_fast = mOpt_inMemory_fast.get(); //hmm
        // for using foreach (we allowed): public final class TasksBundleOnDisk implements TasksBundle, Iterable<Map.Entry<Task, MutableState>> {
        for (Entry<Task, MutableState> taskAndMutable : m_onDisk_slow) {
            m_inMemory_fast.add(taskAndMutable.getKey());
            if (taskAndMutable.getValue().isCompleted()) {
                m_inMemory_fast.getState(taskAndMutable.getKey()).setCompleted(true);
            }
        }
    }

    private void ensureInMemoryFromDiskIsInitialize() {
        if (mOpt_inMemory_fast.isEmpty()) { // like !m_inMemory.isPresent()
            initializeInMemoryFromDisk(); // load all saved task from the disk
        }
        assert (mOpt_inMemory_fast.isPresent());
    }

    @Override
    public void add(final Task task) {
        ensureInMemoryFromDiskIsInitialize();

        try {
            m_onDisk_slow.add(task);
            mOpt_inMemory_fast.get().add(task);
        }
        catch (TaskAlreadyExistsException ex) {
            // we have this file.
        }
    }

    @Override
    public Iterator<Map.Entry<Task, MutableState>> iterator() {
        ensureInMemoryFromDiskIsInitialize();
        return mOpt_inMemory_fast.get().iterator();
    }

    @Override
    public boolean isEmpty() {
        ensureInMemoryFromDiskIsInitialize();
        assert m_onDisk_slow.isEmpty() == mOpt_inMemory_fast.isEmpty();
        return mOpt_inMemory_fast.isEmpty();
    }

    @Override
    public int size() {
        ensureInMemoryFromDiskIsInitialize();
        return mOpt_inMemory_fast.get().size();
    }

    @Override
    public MutableState getState(final Task task) {
        ensureInMemoryFromDiskIsInitialize();
        final MutableState mutableState = mOpt_inMemory_fast.get().getState(task);
        mOpt_inMemory_fast.get().getState(task).setCompleted(mutableState.isCompleted());
        return mutableState;
    }
}
