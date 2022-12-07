import java.util.logging.Level;
import java.util.logging.Logger;

public final class HelloMe {
	public static void main(final String[] args) {
		final Logger logger = Logger.getLogger(HelloSecureWorld.class.getCanonicalName());

		logger.log(Level.INFO, "What is your name?");
		final String name = System.console().readLine();
		
		final String response = "Hello " + name + ".\nNice to meet you.";
		logger.log(Level.WARNING, response);
	}
}

