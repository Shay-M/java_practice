import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

// https://examples.javacodegeeks.com/core-java/java-nio-read-file-example/
public class Type {
    private static final Logger logger = Logger.getLogger(Type.class.getCanonicalName());

    public static void main(final String[] args) {
        if (args.length > 1) {
            final Path path = Paths.get(args[0] + args[1]);
            try {
                Files.lines(path).forEach(System.out::println);//print each line
            }
            catch (IOException ex) {
                ex.printStackTrace();//handle exception here
            }


            /*Path path = Paths.get(args[0] + args[1]);
            try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

                String currentLine = null;
                while ((currentLine = reader.readLine()) != null) {//while there is content on the current line
                    System.out.println(currentLine); // print the current line
                }
            } catch (IOException ex) {
                ex.printStackTrace(); //handle an exception here
            }*/

        }
    }

}
