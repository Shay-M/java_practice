package webaction;

import java.util.Map.Entry;

import pagegen.BasicParts;
import super_simple_web_server.SuperSimpleWebServer.Request;
import tasks.MutableState;
import tasks.Task;
import tasks.TasksBundle;
import tasks.TasksSystemFile;

public class ShowTasks implements WebAction {
    @Override
    public String doAction(Request request, final String untrust_remainingUriParams, final TasksBundle tasks) {
        TasksSystemFile.setName(request.getParams().get("user_name"));
        return BasicParts.tasksHeader(tasks) + BasicParts.tasksList(tasks);
    }
}
