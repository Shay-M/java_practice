package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/tododb";

    public static void main(final String[] args) throws SQLException {
        final Logger logger = Logger.getLogger(JdbcConnection.class.getCanonicalName());

        try (Connection conn = DriverManager.getConnection(DATABASE_URL, args[0], args[1])) {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                // Retrieve by column name
                logger.log(Level.INFO,
                        "Employee: " +
                                rs.getString("username"));
            }
        }
    }

}

