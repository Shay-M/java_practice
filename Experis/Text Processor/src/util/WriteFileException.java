package util;

import java.io.IOException;

public class WriteFileException extends RuntimeException {
    public WriteFileException(final IOException ex) {
        super(ex);
    }
}
