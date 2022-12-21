package commands;

import task.TaskManager;

import java.util.logging.Logger;

public class DeleteTask extends Command {
    public DeleteTask(String url, Logger logger, TaskManager taskManager) {
        super(url, logger, taskManager);
    }

    @Override
    public String go(String[] nameParts) {
        return null;
    }
}
