package tasks;

import db.DataBaseSqlPassword;
import db.JdbcCommands;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class TaskBundleSQLTest extends TasksShearedBundleTests {
    private static final Logger logger = Logger.getLogger(TaskBundleSQLTest.class.getCanonicalName());

    private static final String ROOT_URL = "jdbc:mysql://localhost/";
    private final static String SQL_USER = "root";
    private final static String DB_NAME = "tests";
    private final static Optional<String> SQL_PASSWORD = DataBaseSqlPassword.getPassword(logger);
    private static Connection m_connection;


    @Override
    protected TasksBundle createTasksBundle() {
        if (SQL_PASSWORD.isPresent()) {
            TaskBundleSQL taskBundleSQL = new TaskBundleSQL(m_connection, logger); // now the main this ?
            return taskBundleSQL;
        }
        logger.log(Level.INFO, "Password file not found!\n");
        throw new RuntimeException("An error occurred while accessing the database"); // todo new Exception
    }

    @BeforeAll
    static void initialize() throws SQLException {
        m_connection = DriverManager.getConnection(ROOT_URL + DB_NAME, SQL_USER, SQL_PASSWORD.get());
    }

    @AfterAll
    static void closeConnection() throws SQLException {
        m_connection.close();
    }


    @Test
    void connectToDatabase() {
        Assertions.assertNotNull(createTasksBundle());
    }

    @Test
    void connectToDatabaseWithNullConnection() {
        TaskBundleSQL taskBundleSQL = new TaskBundleSQL(null, logger);
        //Assertions.assertThrowsExactly()
    }


    @BeforeEach
    void resatSql() throws SQLException {
        JdbcCommands.cleanAllTables(m_connection, DB_NAME);
    }


}