package webaction.States;

import model.Contact;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public final class HolidayState implements EventsState {

    @Override
    public EventsState nextState(final LocalDateTime localDateTime) {
       /* if (localDateTime.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return new SabatMode();
        }
        if (Holidays.jewishHolidays.containsKey(localDateTime)) {
            return new HolidayState();
        }
        return this;*/
        return this;
    }

    @Override
    public String printStatus(final LocalDateTime localDateTime, final List<Contact> userContacts) {
        final String holidayName = Holidays.jewishHolidays.get(localDateTime);
        String page = "<br>";
        page += holidayName + "<br>";
        return "" + page;

    }
}