import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import super_simple_web_server.SuperSimpleWebServer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// http://127.0.0.1:1080/
// javac -cp super_simple_web_server.jar MyFirstWebServer.java
// java -cp .;super_simple_web_server.jar MyFirstWebServer

public final class MyFirstWebServer {
	public static void main(final String[] args) {
		final Logger logger = Logger.getLogger(MyFirstWebServer.class.getCanonicalName());
		try {
            SuperSimpleWebServer server = new SuperSimpleWebServer(1080, logger);
			        final List<String> toDoList = new ArrayList<String>();

            while (true) {
                try (SuperSimpleWebServer.Request request = server.waitForRequest()) {
                    String untrust_uri = request.getUri();  
                    if (validateHTTP_URI(untrust_uri)) { //? url 
					 	String[] untrust_nameParts = untrust_uri.split("/");
	                    if (untrust_nameParts.length < 2) {
	                        request.getWriter().write("<li><a href='/shay'>shay</a> </li> <li><a href='/resume'>resume</a> </li> ");
	                    } else {
	                        if (untrust_nameParts[1].equals("shay")) {
	                            request.getWriter().write("My name is Shay.<BR> You killed my java , prepare to die!");
	                        } else if (untrust_nameParts[1].equals("resume")) {
	                            request.getWriter().write("Resume.<BR>Shay<BR><a href='https://www.hit.ac.il/'>hit</a> <BR> <img width='40%' src='https://i.chzbgr.com/thumb800/16763397/h0B023285/funny-memes-programming-memes-developers-coding-memes-coder-coding-nerdy-memes-memes-java-memes'> <BR>"
								+ " " + toDoList);
	                        } else if (untrust_nameParts[1].equals("addtask")) {
									toDoList.add(untrust_nameParts[2]);
								request.getWriter().write(
									"Hello " 
									+ untrust_nameParts[2] + " add to list!");
								}
							
	                        }
	                    }
					}
                }
            
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOException " + ex.getMessage());
            return;
        }
    
	}
	
	public static boolean validateHTTP_URI(String uri) {
		final Logger logger = Logger.getLogger(MyFirstWebServer.class.getCanonicalName());
		logger.log(Level.SEVERE, "uri: " + uri);
		return true;
	}
}

