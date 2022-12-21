import commands.*;
import super_simple_web_server.SuperSimpleWebServer;
import task.TaskManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Router {
    private final static int PORT = 1080; // http://127.0.0.1:1080/
    private final List<Command> urls = new ArrayList<Command>();
    private final int HOME_PAGE = 0;
    private final int PAGE_URI_NAME_INDEX = 1;
    private final Logger m_logger;

    private final TaskManager taskManager;

    public Router(final Logger logger) {
        m_logger = logger;
        taskManager = new TaskManager();
        initializeList();
        assert (urls.size() != 0);
        runServer(logger);
    }

    private void initializeList() {
        urls.add(new ShowAllTasks("ShowAllTasks", m_logger, taskManager)); // Home
        urls.add(new ShowAllTasks("", m_logger, taskManager)); // Home !try!
        urls.add(new AddTask("AddTask", m_logger, taskManager));
        urls.add(new CompletedMarkTask("Completed", m_logger, taskManager));
        urls.add(new NotCompletedMarkTask("NotCompleted", m_logger, taskManager));
        urls.add(new DeleteTask("Delete", m_logger, taskManager));
    }

    private final void runServer(Logger logger) {

        try (final SuperSimpleWebServer server = new SuperSimpleWebServer(PORT, logger)) { //try with resource
            while (true) {
                try (final SuperSimpleWebServer.Request request = server.waitForRequest()) {
                    this.update(request, logger);
                }
            }
        } catch (final IOException ex) {
            logger.log(Level.SEVERE, "IOException " + ex.getMessage());
        }
    }

    public final void update(final SuperSimpleWebServer.Request request, Logger logger) {
        final String uri = request.getUri();
        final String[] nameParts = uri.split("/");

        logger.log(Level.INFO, "nameParts " + uri);

        try {
            if (nameParts.length < 2) {
                request.getWriter().write(urls.get(HOME_PAGE).go(nameParts));
            } else {
                final String urlRout = (nameParts[PAGE_URI_NAME_INDEX]).toLowerCase();
                for (Command commandInList : urls) {
                    if (commandInList.getUrl().toLowerCase().equals(urlRout)) {
                        request.getWriter().write(commandInList.go(nameParts));
                    }
                }
            }
        } catch (final IOException ex) {
            m_logger.log(Level.SEVERE, "IOException " + ex.getMessage());
        }
    }


}
