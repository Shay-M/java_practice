package db;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    String getCustomerName(final int accountNumber);

    Customer getCustomer(final int accountNumber);

    void addCustomer(final Customer customer);

    void updateCustomer(final Customer customer);

    void deleteCustomer(int accountNumber);
}
