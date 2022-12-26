package uriparse;

import org.junit.jupiter.api.Test;
import tasks.Task;

import java.beans.Encoder;
import java.security.SecureRandom;
import java.time.LocalDateTime;
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

    final private LocalDateTime generatLocalDateTime() {
        SecureRandom random = new SecureRandom();
        final int minute = random.nextInt(0, 60);
        final int hour = random.nextInt(0, 24);
        final int day = random.nextInt(1, 31);
        final int month = random.nextInt(1, 12);
        final int year = random.nextInt(1900, 3000);

        final LocalDateTime generateDateTime = LocalDateTime.of(year, month, day, hour, minute);
        return generateDateTime;
    }

    @Test
    void StringToTaskTest() {
        final int numOfTests = 100;
        for (int numOfTestsDone = 0; numOfTestsDone < numOfTests; numOfTestsDone++) {
            final String generatedTaskName = generatString();
            final LocalDateTime generateDateTime = generatLocalDateTime();
            final Task generatTask = new Task(generatedTaskName, generateDateTime);

            final Task task = TaskParser.parseTask();

            final String taskNameAndDate = generatedTaskName + "/" + generateDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd/HHmm"));
            assertEquals(taskNameAndDate, taskLink);
        }
    }

    @Test
    void TaskToStringTest() {
        final int numOfTests = 100;
        for (int numOfTestsDone = 0; numOfTestsDone < numOfTests; numOfTestsDone++) {
            final String generatedTaskName = generatString();
            final LocalDateTime generateDateTime = generatLocalDateTime();
            final Task generatTask = new Task(generatedTaskName, generateDateTime);

            final String taskLink = TaskEncoder.encode(generatTask);

            final String taskNameAndDate = generatedTaskName + "/" + generateDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd/HHmm"));
            assertEquals(taskNameAndDate, taskLink);
        }
    }

}