import db.DataBaseSqlPassword;
import db.SqlDBConnection;
import db.CustomerDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Main {
    private static final Logger m_logger = getLogger(Main.class.getCanonicalName());
    private static final String ROOT_URL = "jdbc:mysql://localhost/";
    private final static String SQL_USER = "root";
    private final static String DB_NAME = "SecondDigitalBankTest";
    private final static Optional<String> SQL_PASSWORD = DataBaseSqlPassword.getPassword(m_logger);
//    private final static int DUPLICATE_SQL_ERROR_NUMBER = 1062;


    public static void main(final String[] args) {
        if (SQL_PASSWORD.isPresent()) {
            try (Connection connection = DriverManager.getConnection(ROOT_URL + DB_NAME, SQL_USER, SQL_PASSWORD.get())) {
                SqlDBConnection sqlDBConnection = new SqlDBConnection(connection, m_logger);
                CustomerDAOImpl workerDao = new CustomerDAOImpl(sqlDBConnection);

                // final String name = workerDao.getCustomer(1000);
                m_logger.log(Level.INFO, "list: " + workerDao.getContact("yosi").get(0).getName());

            }
            catch (SQLException ex) {
                m_logger.log(Level.WARNING, "" + ex.getMessage());
            }
        }

    }
}