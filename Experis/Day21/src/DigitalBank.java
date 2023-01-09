import db.DataBaseSqlPassword;
import db.SqlDBConnection;
import db.CustomerDAOImpl;
import super_simple_web_server.Status;
import super_simple_web_server.SuperSimpleWebServer;
import webaction.ShowCustomerInfo;
import webaction.WebAction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class DigitalBank {
    private static final Logger m_logger = getLogger(DigitalBank.class.getCanonicalName());
    private static final List<Map.Entry<String, WebAction>> PARAMETERIZED_PAGES = new ArrayList<>();
    private static final List<Map.Entry<String, WebAction>> EXACT_PAGES = new ArrayList<>();
    private static final int PORT = 9797;
    // sql
    private static final String ROOT_SQL_URL = "jdbc:mysql://localhost/";
    private final static String SQL_USER = "root";
    private final static String DB_NAME = "SecondDigitalBankTest";
    private final static Optional<String> SQL_PASSWORD = DataBaseSqlPassword.getPassword(m_logger);
//    private final static int DUPLICATE_SQL_ERROR_NUMBER = 1062;

    static {
        // !!! Show syntactic sugar - cleaner, shorter
        PARAMETERIZED_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/", new ShowCustomerInfo()));
        // EXACT_PAGES.add(new AbstractMap.SimpleImmutableEntry<String, WebAction>("/", new Login()));
    }

    private CustomerDAOImpl workerDao;

    public static void main(final String[] args) {
        final DigitalBank server = new DigitalBank();
        startSqlServer(server);

        server.serverLoop();
    }

    private static void startSqlServer(final DigitalBank server) {
        if (SQL_PASSWORD.isPresent()) {
            try (Connection connection = DriverManager.getConnection(ROOT_SQL_URL + DB_NAME, SQL_USER, SQL_PASSWORD.get())) {
                final SqlDBConnection sqlDBConnection = new SqlDBConnection(connection, m_logger);
                server.workerDao = new CustomerDAOImpl(sqlDBConnection, m_logger);

                // final String name = workerDao.getCustomer(1000);
                // m_logger.log(Level.INFO, "list: " + workerDao.getContact("yosi").get(0).getName());
                server.serverLoop();
            }
            catch (SQLException ex) {
                m_logger.log(Level.WARNING, "" + ex.getMessage());
            }

        }
    }

    private void serverLoop() {
        try (SuperSimpleWebServer server = new SuperSimpleWebServer(PORT, m_logger)) {
            while (true) {
                try (SuperSimpleWebServer.Request request = server.waitForRequest()) {
//                    request.getWriter(Status.OK)
//                            .write("<H1>DigitalBank</H1>" + workerDao.getContact("yosi").get(0).getName());
                    handleRequest(request);
                }
            }
        }
        catch (IOException ex) {
            m_logger.log(Level.SEVERE, "IOException " + ex.getMessage());
        }
    }

    private void handleRequest(final SuperSimpleWebServer.Request request) {
        try {
            try {
                final String page = resolvePage(request);
                request.getWriter(Status.OK).write(page);
            }
            catch (PageNotFoundException ex) {
                request.getWriter(Status.NOT_FOUND).write("<H1>Page not found</H1>" + ex.getUri());
            }
            catch (IllegalArgumentException ex) {
                request.getWriter(Status.NOT_FOUND).write("<H1>Illegal argument: " + ex.getMessage() + "</H1>");
            }
        }
        catch (IOException e) {
            m_logger.log(Level.WARNING, e.getMessage());
        }
    }


    private String resolvePage(final SuperSimpleWebServer.Request request) throws PageNotFoundException {

        final String untrust_uri = request.getUri();

        for (Map.Entry<String, WebAction> endPointMapping : EXACT_PAGES) {
            if (untrust_uri.equals(endPointMapping.getKey())) {
                m_logger.log(Level.FINE, "Resolved exactly " + untrust_uri + " to page " + endPointMapping.getKey());
                return endPointMapping.getValue().doAction(request, "", workerDao);
            }
        }

        for (Map.Entry<String, WebAction> endPointMapping : PARAMETERIZED_PAGES) {
            if (untrust_uri.startsWith(endPointMapping.getKey())) {
                final String untrust_remainingUriParams = untrust_uri.substring(endPointMapping.getKey().length());
                m_logger.log(Level.FINE, "Resolved parameterized " + untrust_uri + " to page " + endPointMapping.getKey());
                return endPointMapping.getValue().doAction(request, untrust_remainingUriParams, workerDao);
            }
        }


        throw new PageNotFoundException(untrust_uri);
    }
}