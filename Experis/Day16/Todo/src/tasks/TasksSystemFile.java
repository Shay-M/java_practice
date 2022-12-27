package tasks;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TasksSystemFile {
    private static final String ROOT_PATH = "tasks/";

    public final void createFile(Task task) throws FileAlreadyExistsException {
        createsRootFolder(ROOT_PATH);
        // final String taskCategoryName = task.getName();
        createsFile(ROOT_PATH, task);
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

    private void createsFile(final String filePath, final Task task) throws FileAlreadyExistsException {
        final Path newFilePath = Paths.get(filePath + task.getName());
        try {
            Files.createFile(newFilePath);
        } catch (FileAlreadyExistsException ex) {
            throw new FileAlreadyExistsException(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writerToFiles(filePath, task, false);
    }

    private void writerToFiles(final String filePath, final Task task, final boolean completed) {
        final Path filePathWriter = Paths.get(filePath + task.getName());
        try (BufferedWriter writer = Files.newBufferedWriter(filePathWriter,
                StandardCharsets.UTF_8)) {
            writer.write(task.getName() + "\n" + task.getDueTime() + "\n" + completed);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    // final Map<Task, MutableState> m_tasks = new HashMap<>();

    public final boolean readMutableStateFromFileTasks(final Task task) {
        final Path filePathToRead = Paths.get(ROOT_PATH + task.getName());
        List<Path> listOfFiles = listOfFileInRoot();

        try {
            final List<String> lines = Files.readAllLines(filePathToRead);
            boolean isCompletedFromFile = Boolean.getBoolean(lines.get(2));//todo 2;
            return isCompletedFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e); // IllegalArgumentException?
        }
    }

//    private final LocalDateTime readLocalDateTimeFromFile(Path filePathToRead) {
//        List<Path> listOfFiles = listOfFileInRoot();
//
//        try {
//            final List lines = Files.readAllLines(filePathToRead);
//            String DateTimeFromFile = (String) lines.get(1); // todo 1
//            //return LocalDateTime.of();
//        } catch (IOException e) {
//            throw new RuntimeException(e); // IllegalArgumentException?
//        }
//    }

    public final List listOfFileInRoot() {
        final Path path = Paths.get(ROOT_PATH);
        try (Stream<Path> listOfFiles = Files.list(path)) {
            return listOfFiles.toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    private List listOfTasks() {
//        final Path filePathToRead = Paths.get(ROOT_PATH + task.getName()); //todo need strong key
//        List<Path> listOfPathFiles = listOfFileInRoot();
//        List<Task> tasks = new ArrayList<Task>();
//        for (Path filePath : listOfPathFiles) {
//            tasks.add(new Task(filePath.getFileName(), LocalDateTime.of());)
//        }
//
//        return tasks;
//    }
}

