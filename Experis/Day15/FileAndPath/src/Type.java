import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

// https://examples.javacodegeeks.com/core-java/java-nio-read-file-example/
public class Type {
    private static final Logger logger = Logger.getLogger(Type.class.getCanonicalName());

    public static void main(final String[] args) {
        if (args.length > 1) {
            final Path path = Paths.get(args[0] + args[1]);
            try (final Stream<String> stream = Files.lines(path)) {
                stream.forEach(System.out::println); // .forEach(Logger.);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // BufferedReader
            // Path path = Paths.get(args[0] + args[1]);
            /*try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

                String currentLine = null;
                while ((currentLine = reader.readLine()) != null) { // while there is content on the current line
                    System.out.println(currentLine);
                }
            } catch (IOException ex) {
                ex.printStackTrace(); //handle an exception here
            }*/

        }
    }

}
