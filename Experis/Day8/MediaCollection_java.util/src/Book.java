import java.util.logging.Logger;

public class Book implements OutputableMedia {
    private final Media m_data;
    private final MediaPrinter m_printer;

    public Book(String title, String author) {
        m_data = new Media(title, author);
        m_printer = new BookPrinter();
    }

    public Media getData() {
        return m_data;
    }

    @Override
    public void output(Logger logger) {
        m_printer.output(logger, this.m_data);
    }
}
