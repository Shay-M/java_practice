package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public final class SystemFiles {

    public final void createFile(final Path pathOutput) {
        try {
            Files.createFile(pathOutput.getFileName());
        }
        catch (IOException ex) {
            throw new AccessToTheFileException(ex);
            // throw new FileAlreadyExistsException(ex.getMessage());
        }
    }


    public static final List<String> readFile(final Path pathInput) {
        try {
            List<String> lines = Files.readAllLines(pathInput);
            return lines;
        }
        catch (IOException ex) {
            throw new ReadFileException(ex);
        }

      /*  try (Stream<String> stream = Files.lines(pathInput)) {

        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

       /*try (BufferedReader reader = Files.newBufferedReader(pathInput)) {
            final char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer)) != -1) {
                return lines;
       }*/

    }

    public static void writeTextToFile(final Path filePathWriter, final String line) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePathWriter, StandardCharsets.UTF_8)) {
            writer.write(line);
        }
        catch (IOException ex) {
            throw new WriteFileException(ex);
        }


    }
}

