package db;

import model.Contact;
import model.Customer;
import model.PhoneType;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SqlDBConnection implements AutoCloseable {


    // private final static int DUPLICATE_SQL_ERROR_NUMBER = 1062;
    private Connection m_connection;
    private Logger m_logger;

    public SqlDBConnection(final Connection connection, final Logger logger) {
        m_connection = connection;
        m_logger = logger;
        assert m_connection != null;
        logger.log(Level.INFO, "connection: " + connection.toString());
    }

/*    public String getCustomerNameFromSql(final int accountNumber) {
        final String sqlQuery = "select Name\n" +
                "from contact c\n" +
                "join acount a on c.`ContactId` = a.`AcountType_category_id`\n" +
                "and a.`AccountNumber` = ?;";

        try {
            preparedStatement = m_connection.prepareStatement(sqlQuery);
            final int countQuietenMarks = sqlQuery.replaceAll("[^?]", "").length();
            int index = 0;
            preparedStatement.setInt(++index, accountNumber);
            assert index == countQuietenMarks;
            final ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                throw new IllegalArgumentException("Customer not found! , Account Number: " + accountNumber);
            }
            else {
                index = 0;
                final String nameFromSql = rs.getString(++index);
                assert index == 1;

                return nameFromSql;
            }
        }
        catch (SQLException ex) {
            m_logger.log(Level.INFO, "getMessage: " + ex.getMessage());
            throw new SQLErrorException(ex);
        }
    }*/

    public final List<Contact> getContacts(final String userName) { //todo: final int accountNumber...
        final String sqlQuery = "CALL sp_get_contact(?);";
        try (PreparedStatement preparedStatement = m_connection.prepareCall(sqlQuery)) {
            final int countQuietenMarks = sqlQuery.replaceAll("[^?]", "").length();
            int index = 0;
            preparedStatement.setString(++index, userName);  // ...todo accountNumber
            assert index == countQuietenMarks;
            // final int numberFieldForAssert = Contact.class.getEnclosingConstructor().getParameterCount();
            try (final ResultSet result = preparedStatement.executeQuery()) {
                final List<Contact> contactsUserFromSql = new ArrayList<>();
                while (result.next()) {
                    index = 0;
                    final String nameFromSql = result.getString(++index);
                    final String emailFromSql = result.getString(++index);
                    final int phoneNumberFromSql = result.getInt(++index);
                    final String phoneTypeFromSql = result.getString(++index);
                    assert index == 4; // TODO

                    final Contact contactBySql = new Contact(nameFromSql, emailFromSql, phoneNumberFromSql, phoneTypeFromSql);
                    contactsUserFromSql.add(contactBySql);
                }
                return contactsUserFromSql;
            }
        }
        catch (SQLException ex) {
            m_logger.log(Level.INFO, "getMessage: " + ex.getMessage() + "\n" + ex.getSQLState());
            throw new SQLErrorException(ex);
        }

       /* try {
            preparedStatement = m_connection.prepareStatement(sqlQuery);
            final ResultSet result = preparedStatement.executeQuery();
            final List<Contact> contactsUserFromSql = new ArrayList<>();
            final int numberFieldForAssert = Contact.class.getTypeParameters().length;
            while (result.next()) {
                int index = 0;
                final String nameFromSql = result.getString(++index);
                final String emailFromSql = result.getString(++index);
                final int phoneNumberFromSql = result.getInt(++index);
                final String phoneTypeFromSql = result.getString(++index);
                assert index == numberFieldForAssert;

                final Contact contactBySql = new Contact(nameFromSql, emailFromSql, phoneNumberFromSql, phoneTypeFromSql);
                contactsUserFromSql.add(contactBySql);
            }
            return contactsUserFromSql;
        }
        catch (SQLException ex) {
            m_logger.log(Level.INFO, "getMessage: " + ex.getMessage());
            throw new SQLErrorException(ex);
        }*/

    }

    public Customer getCustomer(final int accountNumber) {

//        m_phoneNumbersMap = new HashMap<>();
//        m_phoneNumbersMap.put(031234567, "PhoneType");
//        CONTACT_1 = new Contact("name1", "a@a.com", m_phoneNumbersMap);
//        m_accountsNumbersMap = new HashMap<>();
//        m_accountsNumbersMap.put(1000, "key");
//        CUSTOMER_1 = new Customer(CONTACT_1, m_accountsNumbersMap, "address1", );
//

        // final Customer customerFromDb = new Customer();


        return null;
    }


    @Override
    public void close() throws Exception {
       /* try {
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new SQLException("close failed. " + e);
        }*/

    }
}
