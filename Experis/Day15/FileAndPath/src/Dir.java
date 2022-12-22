import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Dir {
    private static final Logger logger = Logger.getLogger(Type.class.getCanonicalName());

    public static void main(final String[] args) {
        if (args.length > 0) {
            final Path path = Paths.get(args[0]);
            final Stream<Path> list;
            try {
                list = Files.list(path);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            list.limit(5).forEach(System.out::println);
            // list.limit(5).forEach(Logger::);

        }
    }
}
