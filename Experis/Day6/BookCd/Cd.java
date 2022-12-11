import java.util.logging.Level;
import java.util.logging.Logger;

public final class Cd extends OutputableMedia {
	private final Media m_data;
	private final MediaPrinter m_printer;
	
	public Cd(final String name, final String createdBy, boolean isOriginal, long playtimeInMinutes) {
		m_data = new Media(name, createdBy, isOriginal, playtimeInMinutes);
		m_printer = new CdPrinter();
	}

	@Override
	public void Output(Logger logger) {
		m_printer.Output(logger, m_data);
	}
}
 
