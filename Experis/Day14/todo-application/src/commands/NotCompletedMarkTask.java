package commands;

import task.TaskManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NotCompletedMarkTask extends Command {
    public NotCompletedMarkTask(String url, Logger logger, TaskManager taskManager) {
        super(url, logger, taskManager);
    }

    @Override
    public String go(String[] nameParts) {
        getLogger().log(Level.INFO, "No Completed Mark Task");

        getTaskManager().NotCompleted(nameParts[UriPats.NAME.ordinal()]);

        String body = "No  Completed Task :<BR>";
        body += "" + nameParts[UriPats.NAME.ordinal()];
        body += "<BR><a href='http://127.0.0.1:1080/'>Go back</a>";
        return body;
    }
}
