package webaction.States;

import model.Contact;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

public interface EventsState {
    EventsState nextState(final LocalDateTime localDateTime);

    String printStatus(final LocalDateTime localDateTime, final List<Contact> userContacts);
}
