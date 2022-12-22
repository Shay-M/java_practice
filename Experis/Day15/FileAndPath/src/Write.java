import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Write {
    private static final Logger logger = Logger.getLogger(Write.class.getCanonicalName());

    public static void main(final String[] args) {
        if (args.length > 1) {
            final String pathFromArgs = args[0];
            for (int i = 1; i < args.length; i++) {
                cleanUpFiles(pathFromArgs, args[i]);
                createsFiles(pathFromArgs, args[i]);
                writerToFiles(pathFromArgs, args[i]);
            }
        }
    }

    public static void cleanUpFiles(final String filePath, final String fileName) {
        // Old way:
//        File targetFile = new File(filePath + fileName);
//        targetFile.delete();

        final Path newFilePath = Paths.get(filePath + fileName);
        try {
            Files.delete(newFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e); // no file found
        }
    }

    public static void createsFiles(final String filePath, final String fileName) {
        final Path newFilePath = Paths.get(filePath + fileName);
        try {
            Files.createFile(newFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writerToFiles(final String filePath, final String fileName) {
        final Path newFilePath = Paths.get(filePath + fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(newFilePath,
                StandardCharsets.UTF_8)) {
            writer.write("To be, or not to be. That is the question.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*public static void givenUsingFileOutputStream_whenCreatingFile_thenCorrect() throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)){
        }
    }*/

}