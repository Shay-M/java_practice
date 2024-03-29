package pagegen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.stream.Stream;

import tasks.MutableState;
import tasks.Task;
import tasks.TasksBundle;
import uriparse.TaskEncoder;

public class BasicParts {
    public static String tasksHeader(final TasksBundle tasks) {
        return "<H1>Tasks</H1><H2>"
                + tasks.size() + " total</H2> "
                + "<a href='/newtaskname'>"
                + "<img style='width: 30px; height: 30px;' src='https://i.pinimg.com/736x/d1/60/71/d16071eeff65602827db49576e734139.jpg'></a>"
                + "<br>";
    }

    public static String tasksCategoryHeader(final TasksBundle tasks, final String categoryName) {
        return "<H1>" + categoryName + "</H1><H2>"
                + tasks.size() + " total</H2> "
                + "<a href='/newtaskname'>"
                + "<img style='width: 30px; height: 30px;' src='https://i.pinimg.com/736x/d1/60/71/d16071eeff65602827db49576e734139.jpg'></a>"
                + "<br>";
    }

    public static String tasksList(final TasksBundle tasks) {
        if (tasks.isEmpty()) {
            return "<H3>No tasks, yet...</H3>";
        }

        String page = "<ul>";
        for (Entry<Task, MutableState> entry : tasks) {
            final Task t = entry.getKey();
            final MutableState state = entry.getValue();
            page += "<div>";

            page += "<a href='/check/" + TaskEncoder.encode(t) + "/" + !state.isCompleted() + "'>";
            page += "<img style='width: 18px; height: 18px;' src='";
            page += state.isCompleted()
                    ? "https://thetinylife.com/wp-content/uploads/2017/08/checked-checkbox-512.png"
                    : "https://www.clker.com/cliparts/e/q/p/N/s/G/checkbox-unchecked-md.png";
            page += "'></a> ";

            page += t.getName() + " " + t.getDueTime().toString();
            page += "</div>";
        }

        page += "</ul>";
        return page;
    }

    public static String categoryInSystemFiles() {
        /*if (.length > 0) {
            final Path path = Paths.get(args[0]);
            final Stream<Path> list;
            try {
                list = Files.list(path);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            list.limit(5).forEach(System.out::println);
            // list.limit(5).forEach(Logger::);

        }*/
        String page = "<ul>";
        /*for (Entry<Task, MutableState> entry : tasks) {
            final Task t = entry.getKey();
            final MutableState state = entry.getValue();
            page += "<div>";

            page += "<a href='/check/" + TaskEncoder.encode(t) + "/" + !state.isCompleted() + "'>";
            page += "<img style='width: 18px; height: 18px;' src='";
            page += state.isCompleted()
                    ? "https://thetinylife.com/wp-content/uploads/2017/08/checked-checkbox-512.png"
                    : "https://www.clker.com/cliparts/e/q/p/N/s/G/checkbox-unchecked-md.png";
            page += "'></a> ";

            page += t.getName() + " " + t.getDueTime().toString();
            page += "</div>";
        }*/

        page += "</ul>";
        return page;
    }
}
