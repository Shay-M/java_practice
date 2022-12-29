package webaction;

import super_simple_web_server.SuperSimpleWebServer;
import tasks.TasksBundle;
import tasks.TasksSystemFile;

public class Login implements WebAction {
    @Override
    public String doAction(SuperSimpleWebServer.Request request, String untrust_remainingUriParams, TasksBundle tasks) {
        return "<form action='/showtasks'>Enter user name: <input name='user_name'></form>";
    }

}

