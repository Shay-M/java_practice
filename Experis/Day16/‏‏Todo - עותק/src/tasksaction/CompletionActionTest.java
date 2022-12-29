package tasksaction;

import org.junit.jupiter.api.Test;
import tasks.Task;
import tasks.TasksBundle;
import tasks.TasksBundleInMemory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CompletionActionTest {

    //    @Test
//    void doAction() {
//    }
//
//    @Test
//    void validate() {
//    }
    //
    private static boolean addingTaskAndSetCompletedBoolean(String isCompleted) {
        TasksBundle tasks = new TasksBundleInMemory();

        List<String> input = Arrays.asList("MyTask", "20221225", "1251");
        final AddTaskAction act = new AddTaskAction();
        final Map<String, Object> params = act.validate(input);
        tasks = act.doAction(tasks, params);

        List<String> inputC = Arrays.asList("MyTask", "20221225", "1251", isCompleted);
        final CompletionAction actC = new CompletionAction();
        final Map<String, Object> paramsC = actC.validate(inputC);
        tasks = actC.doAction(tasks, paramsC);

        return tasks.getState((Task)params.get("task")).isCompleted();
    }

    @Test
    void addingOneTaskSetCompletedTrue() {
        assertTrue(addingTaskAndSetCompletedBoolean(String.valueOf(true)));
        // assertEquals(false,addingTaskAndSetCompletedBoolean(String.valueOf(true)));
    }
/*
    @Test
    void addingOneTaskSetCompletedFalse() {
        assertEquals(1, completedSetBoolean(String.valueOf(false)));
    }

    @Test
    void addingOneTaskSetCompletedInvalidFal() {
        try {
            assertEquals(0, completedSetBoolean("fal"));
            Assertions.fail("IllegalArgumentException not thrown for \"fal\"");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

    @Test
    void addingOneTaskSetCompletedEmpty() {
        try {
            assertEquals(0, completedSetBoolean(""));
            Assertions.fail("IllegalArgumentException not thrown for Empty");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

    @Test
    void addingOneTaskSetCompletedEmptySpace() {
        try {
            assertEquals(0, completedSetBoolean(" "));
            Assertions.fail("IllegalArgumentException not thrown for Empty Space");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

    @Test
    void addingOneTaskSetCompletedInvalidFalseFalse() {
        try {
            assertEquals(0, completedSetBoolean("falsefalse"));
            Assertions.fail("IllegalArgumentException not thrown for falseFalse");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }*/
}