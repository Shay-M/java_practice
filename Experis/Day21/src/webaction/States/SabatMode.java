package webaction.States;

import model.Contact;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class SabatMode implements EventsState {

    @Override
    public EventsState nextState(final LocalDateTime localDateTime) {
      return this;
    }

    @Override
    public String printStatus(final LocalDateTime localDateTime, final List<Contact> userContacts) {
        String page = "<br>";
        page += "<br>" + "Sorry... we keep Sabath";
        return "" + page;

    }
}