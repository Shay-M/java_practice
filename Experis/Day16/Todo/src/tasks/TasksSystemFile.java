package tasks;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class TasksSystemFile {
    private static final String ROOT_PATH = "tasks/";
    public static String userNameFolder = "userName";
    public static final int DATE_AND_TIME_LOCATION_IN_LIST = 1;
    public static final int COMPLETED_LOCATION_IN_LIST = 2;
    private long numberOfFile = 0;

    public static void setName(String name) {
        userNameFolder = ROOT_PATH + name + "/";
    }

    public final void createFile(Task task) throws FileAlreadyExistsException {
        if (!userNameFolder.equals("userName")) {
            createsRootFolder(userNameFolder);
            // final String taskCategoryName = task.getName();
            createsFile(userNameFolder, task);
        }
    }

    private void createsRootFolder(final String path) {
        final Path directoriesPath = Paths.get(path);
        try {
            Files.createDirectories(directoriesPath);
        }
        catch (FileAlreadyExistsException ex) {
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to create directory!" + e.getMessage());
        }
    }

    public static void cleanUpFiles() {

        final Path directoryPath = Paths.get(userNameFolder);

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
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createsFile(final String filePath, final Task task) throws FileAlreadyExistsException {
        final Path newFilePath = Paths.get(filePath + task.getName());
        try {
            Files.createFile(newFilePath);
            ++numberOfFile;
        }
        catch (FileAlreadyExistsException ex) {
            throw new FileAlreadyExistsException(ex.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        writerToFiles(filePath, task, false);
    }

    public static void writerToFiles(final String filePath, final Task task, final boolean completed) {
        final Path filePathWriter = Paths.get(userNameFolder + task.getName());
        try (BufferedWriter writer = Files.newBufferedWriter(filePathWriter,
                StandardCharsets.UTF_8)) {
            writer.write(task.getName() + "\n" + task.getDueTime() + "\n" + completed);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public final String readMutableStateFromFileTasks(final String taskName, final int numLineInFile) {
        final Path filePathToRead = Paths.get(userNameFolder + taskName);
        try {
            final List<String> lines = Files.readAllLines(filePathToRead);
            //String test = lines.get(DATE_AND_TIME_LOCATION_IN_LIST); // Boolean.getBoolean - no!
            final String isCompletedFromFile = String.valueOf(lines.get(numLineInFile));
            return isCompletedFromFile;
        }
        catch (IOException e) {
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

    public final List<Path> listOfFileInRoot() {
        createsRootFolder(userNameFolder);
        final Path path = Paths.get(userNameFolder);
        try (Stream<Path> listOfFiles = Files.list(path)) {
            List<Path> listFromFile = listOfFiles.toList();
            numberOfFile = listFromFile.size();
            return listFromFile;
        }
        catch (NoSuchFileException e) {
            throw new java.util.NoSuchElementException();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getNumberOfFile() {
        return numberOfFile;
    }

//    public final Path pathOfFile(String name) {
//        final Path path = Paths.get(ROOT_PATH + name);
//
//    }

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

