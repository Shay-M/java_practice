import java.util.logging.Level;
import java.util.logging.Logger;

public class MediaPrinter {
	public void Output(Logger logger, Media media) {
		logger.log(Level.INFO, media.getName() + " / " + media.getCreatedBy());
	}
}
