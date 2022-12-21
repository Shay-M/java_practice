package commands;

import task.Task;
import task.TaskManager;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowAllTasks extends Command {
    private TaskManager m_taskManager;

    public ShowAllTasks(String url, Logger logger, TaskManager taskManager) {
        super(url, logger, taskManager);
        m_taskManager = taskManager;
    }

    @Override
    public String go(String[] nameParts) {
        getLogger().log(Level.INFO, "Show Profile");
        String body = "All Tasks<BR>";
        body += "" + listToHtml(m_taskManager.getTaskList());
        body += "<BR><a href='http://127.0.0.1:1080/'>Go back</a>";
        return body;
    }

    private String listToHtml(List<Task> tasks) {
        if (tasks.isEmpty()) {
            return "<BR>No task found!<BR>";
        }
        StringBuilder str;
        str = new StringBuilder("<ul>");
        for (Task task : tasks) {

            if (task.isDone()) {
                str.append("<li style=\"color:red;\">");
            } else {
                str.append("<li>");
            }
            str.append(task.getName())
                    .append("\tEnd at: ")
                    .append(task.getLocalDateTime().format(DateTimeFormatter
                            .ofPattern("yyyy.MMMM.dd, EEE HH:mm")))
                    .append("</li>");

        }
        str.append("</ul>");
        return str.toString();

    }
}
