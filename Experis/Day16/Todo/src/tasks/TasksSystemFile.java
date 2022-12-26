package tasks;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class TasksSystemFile {
    private static final String ROOT_PATH = "tasks/";

    public final void createFile(Task task) throws FileAlreadyExistsException {
        createsRootFolder(ROOT_PATH);
        final String taskName = task.getName();
        // final String taskCategoryName = task.getName();
        createsTextFile(ROOT_PATH, taskName);
    }

    private void createsRootFolder(final String path) {
        final Path directoriesPath = Paths.get(path);
        try {
            Files.createDirectories(directoriesPath);
        } catch (FileAlreadyExistsException ex) {
        } catch (IOException e) {
            throw new RuntimeException("Failed to create directory!" + e.getMessage());
        }
    }

    public static void cleanUpFiles() {

        final Path directoryPath = Paths.get(ROOT_PATH);

        if (Files.exists(directoryPath)) {
            try {
                Files.walkFileTree(directoryPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                        Files.delete(path);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path directory, IOException ioException) throws IOException {
                        Files.delete(directory);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private void createsTextFile(final String filePath, final String fileName) throws FileAlreadyExistsException {
        final Path newFilePath = Paths.get(filePath + fileName);
        try {
            Files.createFile(newFilePath);
        } catch (FileAlreadyExistsException ex) {
            throw new FileAlreadyExistsException(ex.getMessage());            //ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writerToFiles(filePath, fileName);
    }

    private void writerToFiles(final String filePath, final String fileName) {
        final Path newFilePath = Paths.get(filePath + fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(newFilePath,
                StandardCharsets.UTF_8)) {
            writer.write("...todo!..");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public final int numberOfFileInRoot() {
        final Path path = Paths.get(ROOT_PATH);
        try (Stream<Path> listOfFiles = Files.list(path)) {
            return (int) listOfFiles.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

