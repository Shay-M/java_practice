package tasks;

import java.nio.file.FileAlreadyExistsException;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

// AutoCloseable bcz we used PreparedStatement must coll close !
public class TaskBundleSQL implements TasksBundle, AutoCloseable { // need AutoCloseable ?
    private final static int DUPLICATE_SQL_ERROR_NUMBER = 1062;
    private PreparedStatement preparedStatement;
    private final Connection m_connection;

    public TaskBundleSQL(final Connection connection, final Logger logger) {
        m_connection = connection;
        logger.log(Level.INFO, "connection: " + connection.toString());
    }

    @Override
    public void add(final Task task) {
        if (task == null) {
            throw new IllegalArgumentException();
        }
        try {
            final String queryInsert = "INSERT INTO task ( taskName, dateTimeEnd, isCompleted)";
            final String queryValues = "VALUES (? , ? , 0 )";
            preparedStatement = m_connection.prepareStatement(queryInsert + " " + queryValues);
            preparedStatement.setString(1, task.getName());
            final Timestamp timestamp = Timestamp.valueOf(task.getDueTime());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.executeQuery();
        }
        catch (SQLException e) {
            if (e.getErrorCode() == DUPLICATE_SQL_ERROR_NUMBER) {
                throw new TaskAlreadyExistsException(task);
            }
            else {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Iterator<Map.Entry<Task, MutableState>> iterator() {
        throw new UnsupportedOperationException();
        // return null;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
        // return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public MutableState getState(final Task task) {
        throw new UnsupportedOperationException();
        // return null;
    }

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
