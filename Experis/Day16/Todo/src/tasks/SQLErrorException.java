package tasks;

import java.sql.SQLException;

public class SQLErrorException extends RuntimeException {

    public final SQLException getException() {
        return m_ex;
    }

    private final SQLException m_ex;

    public SQLErrorException(SQLException ex) {
        m_ex = ex;
    }
}
