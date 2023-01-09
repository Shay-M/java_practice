package model;

public class Customer {
    private final Contact m_contact;
    // private final Map<String, Integer> m_accountsMap;
    private int m_accountNumber;
    private String m_accountType;
    private String m_address;
    private CreditRating m_creditRating;
    private CustomerType m_customerType;

    public Customer(final Contact contact, final int accountNumber, final String accountType, final String address, final CreditRating creditRating, final CustomerType customerType) {
        this.m_contact = contact;
        this.m_accountNumber = accountNumber;
        this.m_accountType = accountType;
        this.m_address = address;
        this.m_creditRating = creditRating;
        this.m_customerType = customerType;
    }

    public Contact getContact() {
        return m_contact;
    }

    public String getAddress() {
        return m_address;
    }

    public void setAddress(final String m_address) {
        this.m_address = m_address;
    }

    public CreditRating getCreditRatingEnum() {
        return m_creditRating;
    }

    public void setCreditRatingEnum(final CreditRating creditRatingEnum) {
        this.m_creditRating = creditRatingEnum;
    }

    public CustomerType getCustomerTypeEnum() {
        return m_customerType;
    }

    public void setCustomerTypeEnum(final CustomerType customerTypeEnum) {
        this.m_customerType = customerTypeEnum;
    }

    public int getAccountNumber() {
        return m_accountNumber;
    }

    public void setAccountNumber(final int accountNumber) {
        this.m_accountNumber = accountNumber;
    }

    public String getAccountType() {
        return m_accountType;
    }

    public void setAccountType(final String accountType) {
        this.m_accountType = accountType;
    }

}
