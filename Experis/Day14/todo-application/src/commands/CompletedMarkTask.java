package commands;

import task.TaskManager;

import java.util.logging.Logger;

public class CompletedMarkTask extends Command {
    public CompletedMarkTask(String url, Logger logger, TaskManager taskManager) {
        super(url, logger, taskManager);
    }

    @Override
    public String go(String[] nameParts) {
        return null;
    }
}
