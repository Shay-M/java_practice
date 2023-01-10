package util;

public class FailedToReadTheFileException extends RuntimeException {
    public FailedToReadTheFileException(final String message) {
        super(message);
    }
}
