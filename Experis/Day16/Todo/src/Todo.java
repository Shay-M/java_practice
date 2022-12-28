import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import super_simple_web_server.Status;
import super_simple_web_server.SuperSimpleWebServer;
import super_simple_web_server.SuperSimpleWebServer.Request;
import tasks.*;
import tasksaction.CompletionAction;
import webaction.*;

import javax.imageio.ImageIO;

public final class Todo {
    private static final Logger s_logger = Logger.getLogger(Todo.class.getCanonicalName());


    private static final List<Entry<String, WebAction>> PARAMETERIZED_PAGES = new ArrayList<>();
    private static final List<Entry<String, WebAction>> EXACT_PAGES = new ArrayList<>();

    static {
        // !!! Show syntactic sugar - cleaner, shorter
        PARAMETERIZED_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/addtask/", new AddTask()));
        PARAMETERIZED_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/check/", new CheckTask()));
        PARAMETERIZED_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/choosetime/", new ChooseTime()));
        PARAMETERIZED_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/category", new EnterCategory()));
        EXACT_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/", new ShowTasks()));
        EXACT_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/newtaskname", new EnterNewTaskName()));
        EXACT_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/choosedate", new ChooseDate()));
    }

    //    private final TasksBundle m_allTasks = new TasksBundleInMemory();
    private final TasksBundle m_allTasks = new TaskBundleCached();

    // private final Map<String, TaskBundleCached> usersTaskBundles = new HashMap<>();


    public static void main(final String[] args) {
        final Todo server = new Todo();

        server.m_allTasks.add(new Task("Buy milk", LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 15))));
        server.serverLoop();

    }

    private void serverLoop() {
        try (SuperSimpleWebServer server = new SuperSimpleWebServer(9797, s_logger)) {
            while (true) {
                try (SuperSimpleWebServer.Request request = server.waitForRequest()) { // try-with-resource
                    if (request.getUri().equals("/favicon.ico")) {
                        Favicon.getFavicon(request);
                    } else {
                        handleRequest(request);
                    }
                }
            }
        }
        catch (IOException ex) {
            s_logger.log(Level.SEVERE, "IOException " + ex.getMessage());
            return;
        }
    }

    private void handleRequest(final Request request) {

        try {
            try {
                final String page = resolvePage(request);
                request.getWriter(Status.OK).write(page);
            }
            catch (PageNotFoundException ex) {
                request.getWriter(Status.NOT_FOUND).write("<H1>Page not found</H1>" + ex.getUri());
            }
            catch (TaskAlreadyExistsException ex) {
                request.getWriter(Status.INTERNAL_ERROR).write("<H1>Task already exists</H1>");
            }
            catch (IllegalArgumentException ex) {
                request.getWriter(Status.NOT_FOUND).write("<H1>Illegal argument: " + ex.getMessage() + "</H1>");
            }
        }
        catch (IOException e) {
            s_logger.log(Level.WARNING, e.getMessage());
        }
    }

    private String resolvePage(final Request request) throws PageNotFoundException {

        final String untrust_uri = request.getUri();

        for (Entry<String, WebAction> endPointMapping : EXACT_PAGES) {
            if (untrust_uri.equals(endPointMapping.getKey())) {
                s_logger.log(Level.FINE, "Resolved exactly " + untrust_uri + " to page " + endPointMapping.getKey());
                return endPointMapping.getValue().doAction(request, "", m_allTasks);
            }
        }

        for (Entry<String, WebAction> endPointMapping : PARAMETERIZED_PAGES) {
            if (untrust_uri.startsWith(endPointMapping.getKey())) {
                final String untrust_remainingUriParams = untrust_uri.substring(endPointMapping.getKey().length());
                s_logger.log(Level.FINE, "Resolved parameterized " + untrust_uri + " to page " + endPointMapping.getKey());
                return endPointMapping.getValue().doAction(request, untrust_remainingUriParams, m_allTasks);
            }
        }


        throw new PageNotFoundException(untrust_uri);
    }
}
