package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

abstract class TasksShearedBundleTests {
    final static Task FIXING_TASK_1 = new Task("testTask1", LocalDateTime.of(LocalDate.of(2001, 1, 1), LocalTime.of(1, 1)));
    final static Task FIXING_TASK_2 = new Task("testTask2", LocalDateTime.of(LocalDate.of(2002, 2, 2), LocalTime.of(2, 2)));

    protected abstract TasksBundle createTasksBundle(); // tasksBundle -כדי שנוכל לעבוד כם שתי סוגי ה

    @Test
    void addingTasks() {
        final TasksBundle tasksBundle = createTasksBundle();
        tasksBundle.add(FIXING_TASK_1);
        assertEquals(1, tasksBundle.size());
        tasksBundle.add(FIXING_TASK_2);
        assertEquals(2, tasksBundle.size());
    }

    @Test
    void duplication() {
        final TasksBundle tasksBundle = createTasksBundle();
        tasksBundle.add(FIXING_TASK_1);
        try {
            tasksBundle.add(FIXING_TASK_1);
            Assertions.fail("TaskAlreadyExistsException not thrown for duplication");
        }
        catch (TaskAlreadyExistsException ex) {

        }
    }

    @Test
    void addNull() {
        final TasksBundle tasksBundle = createTasksBundle();
        try {
            tasksBundle.add(null);
            Assertions.fail("IllegalArgumentException not thrown for null");
        }
        catch (IllegalArgumentException ex) {

        }

    }

    @Test
    void getStateFromTask() {
        final TasksBundle tasksBundle = createTasksBundle();
        tasksBundle.add(FIXING_TASK_1);
        assertTrue(!tasksBundle.getState(FIXING_TASK_1).isCompleted());
    }

    @Test
    void setStateFromTask() {
        final TasksBundle tasksBundle = createTasksBundle();
        tasksBundle.add(FIXING_TASK_1); // Default Completed is false
        tasksBundle.getState(FIXING_TASK_1).setCompleted(true);

        assertTrue(tasksBundle.getState(FIXING_TASK_1).isCompleted());
    }


    @Test
    void getStateFromNullTask() {
        final TasksBundle tasksBundle = createTasksBundle();
        // way 1: test if task is null
        try {
            assertEquals(0, tasksBundle.getState(null));
            Assertions.fail("NullPointerException not thrown for getState on null");
        }
        catch (NullPointerException ex) {

        }
        // way 2: test if task is null: (**)
        assertThrowsExactly(NullPointerException.class, new AddTaskExecutable(tasksBundle));

        // way 3 "Sugar Syntax": test if task is null:
        assertThrowsExactly(NullPointerException.class, () -> tasksBundle.getState(null));


    }

    // (**) for way 2
    private static class AddTaskExecutable implements Executable {
        private final TasksBundle m_tasksBundle;

        public AddTaskExecutable(final TasksBundle tasksBundle) {
            m_tasksBundle = tasksBundle;
        }

        @Override
        public void execute() throws Throwable {
            m_tasksBundle.getState(null);
        }
    }


    @Test
    void EmptyIteratorHasNextTask() {
        final TasksBundle tasksBundle = createTasksBundle();
        assertTrue(!tasksBundle.iterator().hasNext());
    }

    @Test
    void iteratorHasNextTask() {
        final TasksBundle tasksBundle = createTasksBundle();
        tasksBundle.add(FIXING_TASK_1);
        assertTrue(tasksBundle.iterator().hasNext());
    }

    @Test
    void iteratorGetNextTaskOnEmpty() {
        final TasksBundle tasksBundle = createTasksBundle();
        assertThrowsExactly(java.util.NoSuchElementException.class, () -> tasksBundle.iterator().next());
    }

    @Test
    void iteratorGetNextTask() {
        final TasksBundle tasksBundle = createTasksBundle();
        tasksBundle.add(FIXING_TASK_1);
        assertDoesNotThrow(() -> tasksBundle.iterator().next());
    }

}