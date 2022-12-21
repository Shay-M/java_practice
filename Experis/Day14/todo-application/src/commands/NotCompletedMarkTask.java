package commands;

import task.TaskManager;

import java.util.logging.Logger;

public class NotCompletedMarkTask extends Command {
    public NotCompletedMarkTask(String url, Logger logger, TaskManager taskManager) {
        super(url, logger, taskManager);
    }

    @Override
    public String go(String[] nameParts) {
        return null;
    }
}
