package webaction.States;

import model.Contact;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class NormalMode implements EventsState {
    public static final NormalMode INSTANCE = new NormalMode();

    private NormalMode() {
        // for Singleton
    }

    @Override
    public EventsState nextState(final LocalDateTime localDateTime) {
        if (localDateTime.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return new SabatMode();
        }
        if (Holidays.jewishHolidays.containsKey(localDateTime)) {
            // final String holidayName = Holidays.jewishHolidays.get(localDateTime);
            return new HolidayState();
        }
        return this;
    }

    @Override
    public String printStatus(final LocalDateTime localDateTime, final List<Contact> userContacts) {
        String page = "<br>";

        for (Contact contact : userContacts) {
            page += "<br>" + "Name: " + contact.getName();
            page += "<br>" + "Email: " + contact.getEmail();
            page += "<br>" + "PhoneNumber: " + contact.getPhoneNumber();
            page += "<br>" + "PhoneType: " + contact.getPhoneType();
            page += "<br>";
        }

        return "" + page;
    }

}