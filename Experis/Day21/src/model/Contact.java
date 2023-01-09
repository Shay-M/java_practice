package model;

public final class Contact {
    private String m_name;
    private String m_email;
    private int m_phoneNumber;
    private String m_phoneType;

    public int getM_phoneNumber() {
        return m_phoneNumber;
    }

    public void setM_phoneNumber(final int m_phoneNumber) {
        this.m_phoneNumber = m_phoneNumber;
    }

    public String getM_phoneType() {
        return m_phoneType;
    }

    public void setM_phoneType(final String m_phoneType) {
        this.m_phoneType = m_phoneType;
    }

    public Contact(final String m_name, final String m_email, final int mPhoneNumber, final String mPhoneType) {
        this.m_name = m_name;
        this.m_email = m_email;
        m_phoneNumber = mPhoneNumber;
        m_phoneType = mPhoneType;
    }

    public String getName() {
        return m_name;
    }

    public void setName(final String m_name) {
        this.m_name = m_name;
    }

    public String getEmail() {
        return m_email;
    }

    public void setEmail(final String m_email) {
        this.m_email = m_email;
    }


}
