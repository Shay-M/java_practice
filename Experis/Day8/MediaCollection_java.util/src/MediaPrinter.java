import java.util.logging.Level;
import java.util.logging.Logger;

public class MediaPrinter {

    public void output(Logger logger, Media media) {
        logger.log(Level.INFO, media.getName() + " | " + media.getAuthor());
    }
}
