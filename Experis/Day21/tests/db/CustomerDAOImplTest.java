package db;

import model.Contact;
import model.Customer;
import model.PhoneType;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CustomerDAOImplTest {

    private static Map<Integer, PhoneType> m_phoneNumbersMap;
    private static Map<Integer, String> m_accountsNumbersMap;
    private static Contact CONTACT_1;
    private static Customer CUSTOMER_1;

    /*@BeforeAll
    void initialize() {
        PhoneType.
        m_phoneNumbersMap = new HashMap<>();
        m_phoneNumbersMap.put(031234567, "PhoneType");
        CONTACT_1 = new Contact("name1", "a@a.com", m_phoneNumbersMap);
        m_accountsNumbersMap = new HashMap<>();
        m_accountsNumbersMap.put(1000, "key");
        CUSTOMER_1 = new Customer(CONTACT_1, m_accountsNumbersMap, "address1", );
    }*/


//    @Test
//    void addCustomer() {
//
//    }

    @Test
    void getCustomerDetail() {

    }

//    @Test
//    void getCustomersDetails() {
//        WorkerDaoImpl workerDao = new WorkerDaoImpl();
//        final List<Customer> customers = workerDao.getCustomers();
//        Assertions.assertEquals(3, customers.size());
//    }


}