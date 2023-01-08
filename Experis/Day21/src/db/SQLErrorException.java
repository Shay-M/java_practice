package db;

import java.sql.SQLException;

public final class SQLErrorException extends RuntimeException {

    public final SQLException getException() {
        return m_ex;
    }

    private final SQLException m_ex;

    public SQLErrorException(SQLException ex) {
        m_ex = ex;
    }
}
