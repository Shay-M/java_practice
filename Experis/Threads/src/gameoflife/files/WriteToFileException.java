package gameoflife.files;

import java.io.IOException;

public class WriteToFileException extends RuntimeException {
    public WriteToFileException(final IOException ex) {
        super(ex);
    }
}
