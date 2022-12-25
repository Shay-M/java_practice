package tasks;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TasksSystemFile {
    private static final String ROOT_PATH = "tasks/";

    public final void createFile(Task task) {
        createsRootFolder(ROOT_PATH);

        final String taskName = task.getName();
        final String taskCategoryName = task.getName();
        createsTextFile(ROOT_PATH, taskName);
    }

    private void createsRootFolder(final String path) {
        final Path directoriesPath = Paths.get(path);

        try {
            Files.createDirectories(directoriesPath);
        } catch (IOException ex) {
            //throw new RuntimeException(ex); // "Failed to create directory!" + e.getMessage()
            ex.printStackTrace();
        }
    }

    private void createsTextFile(final String filePath, final String fileName) {
        final Path newFilePath = Paths.get(filePath + fileName);
        try {
            Files.createFile(newFilePath);
        } catch (IOException ex) {
            //ex.printStackTrace();
        }

        writerToFiles(filePath, fileName);
    }

    private void writerToFiles(final String filePath, final String fileName) {
        final Path newFilePath = Paths.get(filePath + fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(newFilePath,
                StandardCharsets.UTF_8)) {
            writer.write("...hi..");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
