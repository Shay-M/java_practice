package commands;

import task.TaskManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteTask extends Command {
    public DeleteTask(String url, Logger logger, TaskManager taskManager) {
        super(url, logger, taskManager);
    }

    @Override
    public String go(String[] nameParts) {
        getLogger().log(Level.INFO, "Delete Task");

        getTaskManager().Delete(nameParts[UriPats.NAME.ordinal()]);

        String body = "Delete Task :<BR>";
        body += "" + nameParts[UriPats.NAME.ordinal()];
        body += "<BR><a href='http://127.0.0.1:1080/'>Go back</a>";
        return body;
    }
}
