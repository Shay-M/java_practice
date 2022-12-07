import java.util.logging.Level;
import java.util.logging.Logger;

public final class HelloSecureWorld {
	public static void main(final String[] args) {
		final Logger logger = Logger.getLogger(HelloSecureWorld.class.getCanonicalName());
		logger.log(Level.INFO, "Hello Secure World!");
	}
}

