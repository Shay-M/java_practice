package db;

import model.Contact;
import model.Customer;

import java.util.List;

public final class CustomerDAOImpl implements CustomerDAO {
    private final SqlDBConnection m_sqlDBConnection;

    public CustomerDAOImpl(final SqlDBConnection mSqlDBConnection) {
        m_sqlDBConnection = mSqlDBConnection;
    }


    @Override
    public List<Customer> getCustomers() { // need?
        throw new UnsupportedOperationException();
        // return null;
    }


    @Override
    public Customer getCustomer(final int accountNumber) {

        return m_sqlDBConnection.getCustomer(accountNumber);
    }

    @Override
    public List<Contact> getContact(final String userName) { // remove

        return m_sqlDBConnection.getContacts(userName);
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
