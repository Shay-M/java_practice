import super_simple_web_server.SuperSimpleWebServer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /*
    Decide what the URL/URIs will look like to perform the following actions:
    - Add a task (i.e. localhost:1080/addtask/FeedDog/20221222/0800)
    - Mark a task as completed
    - Mark a task as not completed
    - Delete a task
    In the output show the tasks per-day (Today, Tommorow, etc)
    If a task is expired mark it in red*/
    private final static Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        final Router router = new Router(logger);
    }
}