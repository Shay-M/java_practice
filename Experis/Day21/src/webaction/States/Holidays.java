package webaction.States;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Holidays {

    final static Map<LocalDateTime, String> jewishHolidays = new HashMap<>();

    public Holidays() {
        jewishHolidays.put(LocalDateTime.of(2023, 9, 5, 0, 0), "Rosh Hashanah");
        jewishHolidays.put(LocalDateTime.of(2023, 9, 6, 0, 0), "Rosh Hashanah");
        jewishHolidays.put(LocalDateTime.of(2023, 9, 14, 0, 0), "Yom Kippur");
        jewishHolidays.put(LocalDateTime.of(2023, 9, 19, 0, 0), "Sukkot");
        jewishHolidays.put(LocalDateTime.of(2023, 9, 20, 0, 0), "Sukkot");
        jewishHolidays.put(LocalDateTime.of(2023, 9, 27, 0, 0), "Shemini Atzeret");
        jewishHolidays.put(LocalDateTime.of(2023, 9, 28, 0, 0), "Simchat Torah");
        jewishHolidays.put(LocalDateTime.of(2023, 12, 15, 0, 0), "Chanukah");
        jewishHolidays.put(LocalDateTime.of(2023, 12, 16, 0, 0), "Chanukah");
        jewishHolidays.put(LocalDateTime.of(2023, 12, 17, 0, 0), "Chanukah");
        jewishHolidays.put(LocalDateTime.of(2023, 12, 18, 0, 0), "Chanukah");
        jewishHolidays.put(LocalDateTime.of(2023, 12, 19, 0, 0), "Chanukah");
        jewishHolidays.put(LocalDateTime.of(2023, 12, 20, 0, 0), "Chanukah");
        jewishHolidays.put(LocalDateTime.of(2023, 12, 21, 0, 0), "Chanukah");
        jewishHolidays.put(LocalDateTime.of(2023, 12, 22, 0, 0), "Chanukah");
        jewishHolidays.put(LocalDateTime.of(2023, 1, 26, 0, 0), "Tu Bishvat");
        jewishHolidays.put(LocalDateTime.of(2023, 3, 9, 0, 0), "Purim");
        jewishHolidays.put(LocalDateTime.of(2023, 4, 2, 0, 0), "Passover");
        jewishHolidays.put(LocalDateTime.of(2023, 4, 3, 0, 0), "Passover");
        jewishHolidays.put(LocalDateTime.of(2023, 4, 4, 0, 0), "Passover");
        jewishHolidays.put(LocalDateTime.of(2023, 4, 5, 0, 0), "Passover");
        jewishHolidays.put(LocalDateTime.of(2023, 4, 6, 0, 0), "Passover");
    }
}
