import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import super_simple_web_server.SuperSimpleWebServer;
// http://127.0.0.1:1080/10
public final class MyFirstWebServer {
	public static void main(final String[] args) {
		final Logger logger = Logger.getLogger(MyFirstWebServer.class.getCanonicalName());

		try {
			SuperSimpleWebServer server = new SuperSimpleWebServer(1080, logger);
			try (SuperSimpleWebServer.Request request = server.waitForRequest()) {
				String untrust_uri = request.getUri();
				String[] untrust_nameParts = untrust_uri.split("/");
				if (untrust_nameParts.length < 3) {
					request.getWriter().write("Hello World!<BR>"
						+ "Say hello to <A href='/yariv/tal'>yariv</A> <img width="40%" src="https://www.hit.ac.il/.upload/HomePage/MainStrip/spring-semester-11-2023-990x330.png">");
				}
				else {
					request.getWriter().write(
						"Hello " 
						+ untrust_nameParts[1] + " " 
						+ untrust_nameParts[2] + "!");
				}
			}
		}
		catch (IOException ex) {
			logger.log(Level.SEVERE, "IOException " + ex.getMessage());
			return;
		}
	}
}

