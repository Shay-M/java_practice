package db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseSqlPassword {
    //    private static final String ROOT_PATH = "../../useInApps.pas.txt";
    private static final String ROOT_PATH = "C:/pas.txt";
    static Optional<String> sqlPassword = Optional.empty();

    public final static Optional<String> getPassword(final Logger logger) {
        if (sqlPassword.isPresent()) {
            return sqlPassword;
        }
        else {
            return readSqlPasswordFromFile(logger);
        }
    }

    private static Optional<String> readSqlPasswordFromFile(final Logger logger) {
        final Path filePathToRead = Paths.get(ROOT_PATH);
        logger.log(Level.INFO, "" + filePathToRead.getRoot());
        try {
            sqlPassword = Optional.of(Files.readString(filePathToRead));
            return sqlPassword;
        }
        catch (IOException ex) {
            logger.log(Level.INFO, "Password file not found!\n" + ex.getMessage());
            throw new RuntimeException(ex);// to make new?
        }
    }
}
