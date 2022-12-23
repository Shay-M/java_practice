import commands.*;
import task.TaskManager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TodoWebApplication {

    private final static Logger logger = Logger.getLogger(TodoWebApplication.class.getCanonicalName());

    public static void main(final String[] args) {
        final TaskManager taskManager = new TaskManager();

        final List<Command> urls = new ArrayList<Command>();
        urls.add(new ShowAllTasks("ShowAllTasks", logger, taskManager)); // Home
        urls.add(new ShowAllTasks("", logger, taskManager)); // Home !try!
        urls.add(new AddTask("AddTask", logger, taskManager));
        urls.add(new CompletedMarkTask("Completed", logger, taskManager));
        urls.add(new NotCompletedMarkTask("NotCompleted", logger, taskManager));
        urls.add(new DeleteTask("Delete", logger, taskManager));

        final Router router = new Router(logger, taskManager, urls);
        router.runServer();

    }


}