package util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class SystemFiles {

    public final void createFile(Path pathOutput) {
        try {
            Files.createFile(pathOutput.getFileName());
        }
        catch (IOException ex) {
            throw new AccessToTheFileException(ex);
            // throw new FileAlreadyExistsException(ex.getMessage());
        }
    }


    public final List<String> readFile(Path pathInput) {
        // path = Paths.get("example.txt");
        try {
            List<String> lines = Files.readAllLines(pathInput);
            return lines;
        }
        catch (IOException ex) {
            throw new ReadFileException(ex);
        }

        /*try (Stream<String> lines = Files.lines(path)) {

        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void writeTextToFile(final Path filePathWriter, final String line) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePathWriter, StandardCharsets.UTF_8)) {
            writer.write(line);
        }
        catch (IOException ex) {
            throw new WriteFileException(ex);
        }

    }
}

