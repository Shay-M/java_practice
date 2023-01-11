package util;

import java.io.IOException;

public class ReadFileException extends RuntimeException {
    public ReadFileException(final IOException ex) {
        super(ex);
    }
}
