package webaction;

import pagegen.BasicParts;
import super_simple_web_server.SuperSimpleWebServer;
import tasks.TasksBundle;

import java.time.format.DateTimeFormatter;

public class EnterCategory implements WebAction {
    @Override
    public String doAction(SuperSimpleWebServer.Request request, String untrust_remainingUriParams, TasksBundle tasks) {
        String page = "<H2>Choose a Category or create a new one:</H2>";
        // "<form action='/choosedate'>Enter name for task: <input name='name'></form>";
        page += "<form action='/addtask/" + untrust_remainingUriParams + "'>"
                + "Enter name for task: <input name='name'></form>&nbsp;&nbsp;&nbsp;";

        return page; //BasicParts.categoryInSystemFiles()
    }
}
