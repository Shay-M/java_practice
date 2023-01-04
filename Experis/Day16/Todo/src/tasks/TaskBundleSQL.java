package tasks;

import java.nio.file.FileAlreadyExistsException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

// AutoCloseable bcz we used PreparedStatement must coll close !
public class TaskBundleSQL implements TasksBundle, AutoCloseable { // need AutoCloseable ?
    private final static int DUPLICATE_SQL_ERROR_NUMBER = 1062;
    private PreparedStatement preparedStatement;
    private final Connection m_connection;
    private final Map<Task, MutableState> m_tasks = new HashMap<>();

    public TaskBundleSQL(final Connection connection, final Logger logger) {
        m_connection = connection;
        assert m_connection != null;
        logger.log(Level.INFO, "connection: " + connection.toString());
    }

   /* private void getTasksQuery() { // , final String[] getStrings
        preparedStatement = m_connection.prepareCall("{call AddTask(?, ?)} ");

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
    }*/

    @Override
    public void add(final Task task) {
        if (task == null) {
            throw new IllegalArgumentException();
        }
        try {
            // final String queryInsert = "INSERT INTO task ( taskName, dateTimeEnd, isCompleted)";
            // final String queryValues = "VALUES (? , ? , 0 )";
            // preparedStatement = m_connection.prepareStatement(queryInsert + " " + queryValues);
            final String sqlQuery = "{call AddTask(?, ? ,?)} ";
            final int countQuietenMarks = sqlQuery.replaceAll("[^?]", "").length();
            preparedStatement = m_connection.prepareCall(sqlQuery);
            int index = 0;
            preparedStatement.setString(++index, task.getName());
            final Timestamp timestamp = Timestamp.valueOf(task.getDueTime());
            preparedStatement.setTimestamp(++index, timestamp);
            preparedStatement.setString(++index, "shay"); //todo user name
            assert index == countQuietenMarks;
            preparedStatement.executeQuery();
        }
        catch (SQLException ex) {
            if (ex.getErrorCode() == DUPLICATE_SQL_ERROR_NUMBER) {
                throw new TaskAlreadyExistsException(task);
            }
            else {
                throw new SQLErrorException(ex);
            }
        }
    }

    @Override
    public Iterator<Map.Entry<Task, MutableState>> iterator() { //<<<
        throw new UnsupportedOperationException();
        // return null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        try {
            preparedStatement = m_connection.prepareStatement("SELECT COUNT(*) FROM task;"); //
            final ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            final int count = rs.getInt(1);
            return count;
        }
        catch (SQLException ex) {
            throw new SQLErrorException(ex);
        }
    }

    @Override
    public MutableState getState(final Task task) { //< <
        // NullPointerException

        try {
            preparedStatement = m_connection.prepareStatement(
                    "SELECT *\n" +
                            "FROM task t\n" +
                            "WHERE" +
                            "taskName = ? " +
                            "AND dateTimeEnd = ?  " +
                            "AND isCompleted = ?;"
            );

            final ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                throw new IllegalArgumentException("Task not found: " + task.toString());
            }
            else {
                int index = 0;
                final String taskNameFromSql = rs.getString(++index);
                final Timestamp taskTimestampFromSql = rs.getTimestamp(++index);
                final LocalDateTime localDateTimeFromTimestamp = taskTimestampFromSql.toLocalDateTime();
                final boolean taskCompletedFromSql = rs.getBoolean(++index); // .getShort(++index);
                assert index == 3;

                Task taskFromSql = new Task(taskNameFromSql, localDateTimeFromTimestamp);
                MutableState mutableStateFromSql = new MutableState();
                mutableStateFromSql.setCompleted(taskCompletedFromSql);
                return mutableStateFromSql;
            }
        }
        catch (SQLException ex) {
            throw new SQLErrorException(ex);
        }
    }

    // ---------------------------------- see
    @Override
    public void close() throws SQLException {
        try {
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new SQLException("close failed. " + e);
        }
    }
}
