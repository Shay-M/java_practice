package webaction;

import java.time.DateTimeException;
import java.util.Arrays;
import java.util.Map;

import pagegen.BasicParts;
import super_simple_web_server.SuperSimpleWebServer.Request;
import tasks.TasksBundle;
import tasksaction.TasksAction;

public class AddTask implements WebAction {

	@Override
	public String doAction(Request request, String untrust_remainingUriParams, TasksBundle tasks) {
		try {
			int oldSize = tasks.size();

			String[] untrust_params = untrust_remainingUriParams.split("/");
			TasksAction act = new tasksaction.AddTaskAction();
			Map<String, Object> params = act.validate(Arrays.asList(untrust_params));
			assert (params.size() == 1);
			act.doAction(tasks, params);
	
			assert (tasks.size() == oldSize + 1);
	
			return BasicParts.tasksHeader(tasks) + BasicParts.tasksList(tasks);
		}
		catch (DateTimeException ex) {
			throw new IllegalArgumentException(ex.getMessage());
		}
	}

}
