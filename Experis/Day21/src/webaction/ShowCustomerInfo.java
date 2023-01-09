package webaction;

import db.CustomerDAO;
// import pagegen.BasicParts;
import model.Contact;
import super_simple_web_server.SuperSimpleWebServer.Request;

import java.time.DateTimeException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ShowCustomerInfo implements WebAction {

    @Override
    public String doAction(final Request request, final String untrust_remainingUriParams, final CustomerDAO customerDAO) {
        String page = "<H2>Digital Bank</H2>";
        final List<Contact> userContacts = customerDAO.getContact("yosi");

        for (Contact contact : userContacts) {
            page += "<br>" + "Name: " + contact.getName();
            page += "<br>" + "Email: " + contact.getEmail();
            page += "<br>" + "PhoneNumber: " + contact.getPhoneNumber();
            page += "<br>" + "PhoneType: " + contact.getPhoneType();
            page += "<br>";
        }
        return page;
    }
}

