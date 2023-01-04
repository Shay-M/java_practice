package db;

import java.sql.*;

public class JdbcCommands {
    //SET foreign_key_checks = 0;
    //TRUNCATE TABLE tests.task;
    //ALTER TABLE tests.task AUTO_INCREMENT = 1;
    //SET foreign_key_checks = 1;
    public static final void cleanAllTables(final Connection connection, final String dataBase) throws SQLException {
        assert connection != null;
        /*
        Statement stmt = conn.createStatement();
        String query = "SET foreign_key_checks = 0;";
        query += "TRUNCATE TABLE " + dataBase + "." + tableName + ";";
        query += "ALTER TABLE " + dataBase + "." + tableName + " AUTO_INCREMENT = 1;";
        query += "SET foreign_key_checks = 1;";
        tmt.executeUpdate(query);
        */
        final PreparedStatement preparedStatement;
//        preparedStatement = connection.prepareCall("{call ?.DeleteTable()} "); // not work?
        //preparedStatement.setString(1, dataBase);
        preparedStatement = connection.prepareCall("{call tests.DeleteTable()} ");
        preparedStatement.executeQuery();

    }


}

