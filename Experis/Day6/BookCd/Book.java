import java.util.logging.Level;
import java.util.logging.Logger;

public final class Book extends OutputableMedia {
	private final Media m_data;
	private final MediaPrinter m_printer;

	public Book(final String name, final String createdBy) {
		m_data = new Media(name, createdBy);
		m_printer = new MediaPrinter();
	}

	@Override
	public void Output(Logger logger) {
		m_printer.Output(logger, m_data);
	}
}

