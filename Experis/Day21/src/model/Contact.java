package model;

public final class Contact {
    private String m_name;
    private String m_email;
    private int m_phoneNumber;
    private String m_phoneType;

    // private final Map<String, Integer> m_phoneNumbersMap;


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
