package model;

import java.util.Map;

public class Customer {
    private final Contact m_contact;
    private final Map<String, Integer> m_accountsMap;
    private String m_address;
    private CreditRating creditRatingEnum;
    private CustomerType customerTypeEnum;

    public Customer(final Contact mContact, final Map<String, Integer> m_accountsMap, final String m_address, final CreditRating creditRatingEnum) {
        m_contact = mContact;
        this.m_accountsMap = m_accountsMap;
        this.m_address = m_address;
        this.creditRatingEnum = creditRatingEnum;

    }

    public Contact getM_contact() {
        return m_contact;
    }

    public Map<String, Integer> getM_accountsMap() {
        return m_accountsMap;
    }

    public String getM_address() {
        return m_address;
    }

    public void setM_address(final String m_address) {
        this.m_address = m_address;
    }

    public CreditRating getCreditRatingEnum() {
        return creditRatingEnum;
    }

    public void setCreditRatingEnum(final CreditRating creditRatingEnum) {
        this.creditRatingEnum = creditRatingEnum;
    }

    public CustomerType getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCustomerTypeEnum(final CustomerType customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }


}
