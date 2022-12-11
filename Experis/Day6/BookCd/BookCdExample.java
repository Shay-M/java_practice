import java.util.logging.Level;
import java.util.logging.Logger;

public final class BookCdExample {
	private static final Logger logger = Logger.getLogger(HomeLib.class.getCanonicalName());

	public static void main(final String[] args) {
		OutputableMedia media[] = new OutputableMedia[] { 
			new Book("Harry Potter", "J.K. Rolling"),
			new Cd("The Wall", "Pink Floyd", false, 79)
		};

		for (OutputableMedia m : media) {
			m.Output(logger);
		}
	}
}
