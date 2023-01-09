package webaction;

import db.CustomerDAO;
import model.Contact;
import super_simple_web_server.SuperSimpleWebServer.Request;
import webaction.States.EventsState;
import webaction.States.NormalMode;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ShowCustomerInfo implements WebAction {

    @Override
    public String doAction(final Request request, final String untrust_remainingUriParams, final CustomerDAO customerDAO) {
        String page = "<H2>Digital Bank</H2>";
        final LocalDateTime localDateTime = LocalDateTime.now();
        page += "" + localDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE);
        // check if we need dark mode
        if (localDateTime.getHour() > LocalTime.of(18, 0, 0).getHour()) {
            page += "<body style='background-color:powderblue;'>";
        }
        final List<Contact> userContacts = customerDAO.getContact("yosi");
        EventsState eventsState = NormalMode.INSTANCE; //  EventsState eventsState = new NormalMode();
        page += eventsState.printStatus(localDateTime, userContacts);

        return page;
    }

}

