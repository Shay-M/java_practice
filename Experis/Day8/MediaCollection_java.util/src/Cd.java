import java.util.logging.Logger;

public class Cd implements OutputableMedia {
    private final Media m_data;
    private final MediaPrinter m_printer;

    public Cd(String title, String author, boolean isOriginal) {
        m_data = new Media(title, author, isOriginal);
        m_printer = new CdPrinter();
    }

    public Media getData() {
        return m_data;
    }

    @Override
    public void output(Logger logger) {
        m_printer.output(logger, this.m_data);
    }
}
