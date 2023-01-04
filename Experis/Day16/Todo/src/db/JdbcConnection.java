package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {
    private final static Logger logger = Logger.getLogger(JdbcConnection.class.getCanonicalName());
    private final static String ROOT_URL = "jdbc:mysql://localhost/";
    private final static String USER = "root";
    private final static String PASSWORD = "123456"; //new Scanner(System.in).nextLine();
    private final static String DATABASE_URL_tests = "tests";

//    public static Statement connectionGetStatement(final String databaseUrl) throws SQLException {
//        try (Connection conn = DriverManager.getConnection(ROOT_URL + databaseUrl, USER, PASSWORD)) {
//            Statement stmt = conn.createStatement();
//            return stmt;
//        }
//    }

    public static final void deleteTable(final String dataBase, final String tableName) {
        try (Connection conn = DriverManager.getConnection(ROOT_URL + DATABASE_URL_tests, USER, PASSWORD)) {
            /*
            SET foreign_key_checks = 0;
            TRUNCATE TABLE tests.task;
            ALTER TABLE tests.task AUTO_INCREMENT = 1;
            SET foreign_key_checks = 1;
            */
            Statement stmt = conn.createStatement();
            String query = "SET foreign_key_checks = 0;";
            query += "TRUNCATE TABLE " + dataBase + "." + tableName + ";";
            query += "ALTER TABLE " + dataBase + "." + tableName + " AUTO_INCREMENT = 1;";
            query += "SET foreign_key_checks = 1;";

            stmt.executeUpdate(query);
        }
        catch (SQLException ex) {
            logger.log(Level.INFO, "" + ex.getMessage());
        }

    }


}

