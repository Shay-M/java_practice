import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Optional;

public final class MediaIteratorExample {
	private static final Logger logger = Logger.getLogger(MediaIteratorExample.class.getCanonicalName());

	public static void main(final String[] args) {
		MediaCollection mc = new LinkedMediaCollection();
		mc.add(new Media("Harry Potter", "J.K.Rolling"));
		mc.add(new Media("Jungle Book", "Kipling"));
		mc.add(new Media("The Little Prince", "Anton"));

		MediaIterator itr = mc.iterator();
		while (itr.hasNext()) {
			Media media = itr.next();
			logger.log(Level.INFO, media.getName());
		}
	}
}


