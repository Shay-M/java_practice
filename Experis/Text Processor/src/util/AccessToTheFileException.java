package util;

import java.io.IOException;

public class AccessToTheFileException extends RuntimeException {
    public AccessToTheFileException(final IOException ex) {
        super(ex);
    }
}
