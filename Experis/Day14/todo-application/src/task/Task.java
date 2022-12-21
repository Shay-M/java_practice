package task;

import java.time.LocalDateTime;

public class Task {
    private final String name;
    private final LocalDateTime localDateTime;


    public String getName() {
        return name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    private boolean isDone = false;

    public Task(final String name, final LocalDateTime endDateTime) {
        this.name = name;
        this.localDateTime = endDateTime;
    }
}
