package uriparse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.Task;

import java.security.SecureRandom;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class TaskParserAndEncoderTest {

    final private String generatString() {
        final SecureRandom random = new SecureRandom();
        final int stringLength = random.nextInt(1, 20);
        final byte bytes[] = new byte[stringLength];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

        final String generatedString = encoder.encodeToString(bytes);
        return generatedString;
    }

    final private LocalDate generateDate() {
        final SecureRandom random = new SecureRandom();
        final int day = random.nextInt(1, 31);
        final int month = random.nextInt(1, 12);
        final int year = random.nextInt(1900, 3000);

        final LocalDate randomDate = LocalDate.of(year, month, day);
        return randomDate;
    }

    final private LocalTime generateTime() {
        final SecureRandom random = new SecureRandom();
        final int minute = random.nextInt(0, 60);
        final int hour = random.nextInt(0, 24);

        final LocalTime randomTime = LocalTime.of(hour, minute);
        return randomTime;
    }

    final private LocalDateTime generateDateTime() {
        final LocalDateTime generateDateTime = LocalDateTime.of(generateDate(), generateTime());
        return generateDateTime;
    }

    @Test
    void StringToTaskTest() {
        final int numOfTests = 100;
        for (int numOfTestsDone = 0; numOfTestsDone < numOfTests; numOfTestsDone++) {
            final String generatedTaskName = generatString();
            final LocalDate generateDate = generateDate();
            final LocalTime generateTime = generateTime();

            final Task taskByStrings = TaskParser.parseTask(
                    generatedTaskName,
                    generateDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")),
                    generateTime.format(DateTimeFormatter.ofPattern("HHmm")));

            final Task task = new Task(generatedTaskName, LocalDateTime.of(generateDate, generateTime));

            assertEquals(taskByStrings, task);
        }
    }

    @Test
    void TaskToStringTest() {
        final int numOfTests = 100;
        for (int numOfTestsDone = 0; numOfTestsDone < numOfTests; numOfTestsDone++) {
            final String generatedTaskName = generatString();
            final LocalDateTime generateDateTime = generateDateTime();
            final Task generatTask = new Task(generatedTaskName, generateDateTime);

            final String taskLink = TaskEncoder.encode(generatTask);

            final String taskNameAndDate = generatedTaskName + "/" + generateDateTime
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd/HHmm"));
            assertEquals(taskNameAndDate, taskLink);
        }
    }
    // 'February 29' as '2057' is not a leap year
    // Invalid date 'FEBRUARY 30'

    @Test
    void TimeStringInvalid() {
        assertThrowsExactly(NullPointerException.class, () ->
        {
            final Task taskByStrings = TaskParser.parseTask(
                    "TaskName",
                    "20000202",
                    "2500"); //<--
            Assertions.fail("DateTimeException not thrown for 25:00.");
        });
    }
}