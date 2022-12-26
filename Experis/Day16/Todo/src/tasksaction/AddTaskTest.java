package tasksaction;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.*;

import tasks.*;

class AddTaskTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void addingOneTask() {
        TasksBundle tasks = new TasksBundleInMemory();
        assertEquals(0, tasks.size());

        List<String> input = Arrays.asList("MyTask", "20221225", "1251");
        AddTaskAction act = new AddTaskAction();
        Map<String, Object> params = act.validate(input);
        tasks = act.doAction(tasks, params);

        // ensure task was added
        assertEquals(1, tasks.size());

        // Ensure iterator works
        Iterator<Entry<Task, MutableState>> itr = tasks.iterator();
        assertTrue(itr.hasNext());

        // Ensure added task has correct details
        Entry<Task, MutableState> newTask = itr.next();
        assertTrue(!itr.hasNext());
        assertEquals("MyTask", newTask.getKey().getName());
        assertEquals(LocalDateTime.of(2022, 12, 25, 12, 51), newTask.getKey().getDueTime());
    }

    ////
    private static TasksBundle stringsTests(TasksBundle tasks, final String name, final String date, final String time) {
        final List<String> input = Arrays.asList(name, date, time);
        final AddTaskAction act = new AddTaskAction();
        final Map<String, Object> params = act.validate(input);
        tasks = act.doAction(tasks, params);
        return tasks;
    }

    private static int stringsTests(final String name, final String date, final String time) {
        TasksBundle tasks = new TasksBundleInMemory();

        tasks = stringsTests(tasks, name, date, time);

        return tasks.size();
    }

    @Test
    void testEmptyTimeString() {
        try {
            assertEquals(0, stringsTests("MyTask_EmptyTimeString", "20221225", ""));
            Assertions.fail("IllegalArgumentException not thrown for string  - Empty Time");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

    @Test
    void testInvalidTimeString100() {
        try {
            assertEquals(0, stringsTests("MyTask_EmptyTimeString", "20221225", "100"));
            Assertions.fail("IllegalArgumentException not thrown for string  - Invalid Time");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

    @Test
    void testEmptyDateString() {
        try {
            assertEquals(0, stringsTests("MyTask_EmptyDateString", "", "1251"));
            Assertions.fail("IllegalArgumentException not thrown for string - Empty Date");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

    @Test
    void testInvalidDateString202212() {
        try {
            assertEquals(0, stringsTests("MyTask_EmptyTimeString", "202212", "1251"));
            Assertions.fail("IllegalArgumentException not thrown for string  - Invalid Date");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

    @Test
    void testEmptyNameString() {
        try {
            assertEquals(0, stringsTests("", "20221225", "1251"));
            Assertions.fail("IllegalArgumentException not thrown for string - Empty Name ");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

    @Test
    void testEmptyNameSpaceString() {
        try {
            assertEquals(0, stringsTests(" ", "20221225", "1251"));
            Assertions.fail("IllegalArgumentException not thrown for string - Empty Name only Spaces");
        } catch (IllegalArgumentException ex) {
            // all is good
        }
    }

   /* @Test
    void testAddingDuplicateTask() {
        try {
            stringsTests("MyTask_AddingDuplicateTask", "20221225", "1251");
            stringsTests("MyTask_AddingDuplicateTask", "20221225", "1251");
            Assertions.fail("Did not throw exception for duplicate task");
        } catch (TaskAlreadyExistsException ex) {
            // all is good
        }
    }*/

}
