import commands.*;
import super_simple_web_server.SuperSimpleWebServer;
import task.TaskManager;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Router {
    private final static int HOME_PAGE = 0;
    private final static int PAGE_URI_NAME_INDEX = 1;
    private final static int PORT = 1080; // http://127.0.0.1:1080/

    private final List<Command> m_commands;
    private final Logger m_logger;

    public Router(final Logger logger, final TaskManager taskManager, final List<Command> commands) {
        m_logger = logger;
        m_commands = commands;
        assert (m_commands.size() != 0);
    }

    public final void runServer() {
        try (final SuperSimpleWebServer server = new SuperSimpleWebServer(PORT, m_logger)) { //try with resource
            while (true) {
                try (final SuperSimpleWebServer.Request request = server.waitForRequest()) {
                    this.update(request, m_logger);
                }
            }
        } catch (final IOException ex) {
            m_logger.log(Level.SEVERE, "IOException " + ex.getMessage());
        }
    }

    private void update(final SuperSimpleWebServer.Request request, final Logger logger) {
        final String uri = request.getUri();
        final String[] nameParts = uri.split("/");

        logger.log(Level.INFO, "nameParts " + uri);

        try {
            if (nameParts.length < 2) {
                request.getWriter().write(m_commands.get(HOME_PAGE).go(nameParts));
            } else {
                final String urlRout = (nameParts[PAGE_URI_NAME_INDEX]).toLowerCase();
                for (Command commandInList : m_commands) {
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
