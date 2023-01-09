package db;

import model.Contact;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CustomerDAOImpl implements CustomerDAO {
    private final SqlDBConnection m_sqlDBConnection;
    private final Logger m_logger;

    public CustomerDAOImpl(final SqlDBConnection mSqlDBConnection, final Logger logger) {
        m_sqlDBConnection = mSqlDBConnection;
        m_logger = logger;
    }


    @Override
    public List<Customer> getCustomers() { // need?
        throw new UnsupportedOperationException();
        // return null;
    }


    @Override
    public Customer getCustomer(final int accountNumber) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Contact> getContact(final String userName) { // remove
        final String sqlQuery = "CALL sp_get_contact(?);";
        try (PreparedStatement preparedStatement = m_sqlDBConnection.getTheConnection().prepareCall(sqlQuery)) {
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

    }


    @Override
    public void addCustomer(final Customer customer) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void updateCustomer(final Customer customer) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteCustomer(final int id) {
        throw new UnsupportedOperationException();

    }
}
