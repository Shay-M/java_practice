package commands;

import task.TaskManager;

import java.util.logging.Logger;

public abstract class Command {

    private final String m_url;
    private final Logger m_logger;
    private TaskManager m_taskManager;

    protected TaskManager getTaskManager() {
        return m_taskManager;
    }

    public Command(String url, Logger logger, TaskManager taskManager) {
        m_url = url;
        m_logger = logger;
        m_taskManager = taskManager;
    }


    public String getUrl() {
        return m_url.toLowerCase();
    }

    public Logger getLogger() {
        return m_logger;
    }

    public abstract String go(final String[] nameParts);


}
