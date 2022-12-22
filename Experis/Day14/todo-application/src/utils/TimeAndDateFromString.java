package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeAndDateFromString {

    public final static LocalTime TimeFromString(Logger logger, String time) {
        final LocalTime endTime = LocalTime.parse(
                time,
                DateTimeFormatter.ofPattern("HHmm")
        );
        logger.log(Level.INFO, "" + endTime.toString());

        return endTime;
    }

    public final static LocalDate DateFromString(Logger logger, String date) {
        final LocalDate endDate = LocalDate.parse(
                date,
                DateTimeFormatter.BASIC_ISO_DATE
        );
        logger.log(Level.INFO, "" + endDate.toString());

        return endDate;
    }
}
