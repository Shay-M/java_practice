package db;

import model.Contact;
import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    String getCustomerName(final int accountNumber);

    Customer getCustomer(final int accountNumber);

    List<Contact> getContact(final String userName);

    void addCustomer(final Customer customer);

    void updateCustomer(final Customer customer);

    void deleteCustomer(int accountNumber);
}
