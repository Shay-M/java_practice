package tasks;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class TaskBundleSQL_OLD implements TasksBundle { //
    final static Logger logger = Logger.getLogger(TaskBundleSQL_OLD.class.getCanonicalName());

    private static final String ROOT_URL = "jdbc:mysql://localhost/";
    private final static String SQL_USER = "root";
    private final static String PASSWORD = "123456"; //new Scanner(System.in).nextLine();

    private final Map<Task, MutableState> m_tasks = new HashMap<>();
    private String m_databaseUrl;

    public TaskBundleSQL_OLD(final String databaseUrl) {
        m_databaseUrl = databaseUrl;
        // sendSelectQuery("* from v_users", new String[]{"username", "userId"});
        getTasksQuery("* from v_ueser_list"); // > users
        // logger.log(Level.INFO, "m_tasks: " + m_tasks.toString());
    }

    private void getTasksQuery(final String executeQuery) { // , final String[] getStrings
        try (Connection conn = DriverManager.getConnection(ROOT_URL + m_databaseUrl, SQL_USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select " + executeQuery);
            while (result.next()) {
                final String taskName = result.getString("taskName");
                final LocalDateTime taskLocalDate = result.getTimestamp("dateTimeEnd").toLocalDateTime();
                Task taskFromSql = new Task(taskName, taskLocalDate);

                final boolean taskIsCompletedFromSql = result.getBoolean("isCompleted");
                MutableState mutableStateFromSql = new MutableState();
                mutableStateFromSql.setCompleted(taskIsCompletedFromSql);

                m_tasks.put(taskFromSql, mutableStateFromSql);
            }
        }
        catch (SQLException ex) {
            logger.log(Level.INFO, "" + ex.getMessage());
        }
    }


    private void sendSelectQuery(final String executeQuery, final String[] getStrings) {
        try (Connection conn = DriverManager.getConnection(ROOT_URL, SQL_USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            // stmt.executeUpdate()
            ResultSet rs = stmt.executeQuery("select " + executeQuery);
            while (rs.next()) {
                // Retrieve by column name
                for (String getString : getStrings) {
                    logger.log(Level.INFO, getString + ": " + rs.getString(getString));
                }

            }
        }
        catch (SQLException ex) {
            logger.log(Level.INFO, "" + ex.getMessage());
        }
    }

    @Override
    public void add(Task task) {
        try (Connection conn = DriverManager.getConnection(ROOT_URL + m_databaseUrl, SQL_USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            final String queryInsert = "INSERT INTO task ( taskName, dateTimeEnd, isCompleted)";
            final String queryValues = "VALUES ('" + task.getName() + "','" + task.getDueTime() + "',0)";
            stmt.executeUpdate(queryInsert + " " + queryValues);
        }
        catch (SQLException ex) {
            logger.log(Level.INFO, "" + ex.getMessage() + "   " + ex.getSQLState());
        }

    }

    @Override
    public Iterator<Map.Entry<Task, MutableState>> iterator() {
        return m_tasks.entrySet().iterator();
    }

    @Override
    public boolean isEmpty() {
        return m_tasks.isEmpty();
    }

    @Override
    public int size() {
        return m_tasks.size();
    }

    @Override
    public MutableState getState(Task task) {
        if (!m_tasks.containsKey(task)) {
            throw new IllegalArgumentException("task not found: " + task.toString());
        }

        return m_tasks.get(task);
    }


}
