import java.util.logging.Level;
import java.util.logging.Logger;

public final class CdPrinter extends MediaPrinter {
	@Override
	public final void Output(Logger logger, Media media) {
		logger.log(Level.INFO, media.getName() 
			+ " / " + media.getCreatedBy() 
			+ (media.isOriginal() ? "" : " (copy)")
			+ getPlaytime(media)
		);
	}

	private String getPlaytime(Media media) {
		return media.getPlaytimeInMinutes().isPresent()
			? " " + String.valueOf(media.getPlaytimeInMinutes().get()) + " minutes"
			: "";
	}

}
