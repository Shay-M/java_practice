package commands;

import task.TaskManager;
import utils.TimeAndDateFromString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.TimeAndDateFromString.TimeFromString;

public class AddTask extends Command {

    public AddTask(String url, Logger logger, TaskManager taskManager) {
        super(url, logger, taskManager);
    }

    @Override
    public String go(final String[] dayAndTime) {
        String body = "";
        if (dayAndTime.length == 5) {
            final TimeAndDateFromString timeAndDateFromString = new TimeAndDateFromString();
            final String nameTask = dayAndTime[UriPats.NAME.ordinal()];
            try {
               // TimeFromString(getLogger(), dayAndTime[UriPats.DATE.ordinal()]);
                final LocalDate endDate = timeAndDateFromString.DateFromString(getLogger(), dayAndTime[UriPats.DATE.ordinal()]);
                final LocalTime endTime = TimeFromString(getLogger(), dayAndTime[UriPats.TIME.ordinal()]);
                final LocalDateTime localDateTime = LocalDateTime.of(endDate, endTime);
                getTaskManager().add(nameTask, localDateTime);

                getLogger().log(Level.INFO, "add task!");
                body = "Task added:<BR>";
                body += "Name: " + nameTask + "<BR>End Date: " + endDate + "<BR>EndTime: " + endTime;
            }
            catch (DateTimeParseException ex) {
                getLogger().log(Level.INFO, "Date or Time isn't correct !");
                body = "Date or Time isn't correct !<BR>";
            }

        }
        else {
            body += "<BR>not good uri!<BR>";
        }
        body += "<BR> <a href='http://127.0.0.1:1080/'>Go back</a>";
        return body;
    }

}
