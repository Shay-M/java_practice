package gameoflife.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveFiles {

    private final Path m_filePath;

    public SaveFiles(final Path filePath) {
        m_filePath = filePath;
    }

    public final void createTheOutputDirectory() {
        // java Life movie/frame 100 4  200 200
        if (!Files.exists(m_filePath)) {
            try {
                // Files.createDirectory(outputDir.getParent());
                Files.createDirectories(m_filePath);
            }
            catch (IOException ex) {
                throw new CreateFolderException(ex);
            }
        }
    }

    public final void saveCurrentGenerationToFile(final int generation, final int height, final int width, final boolean[][] currentGeneration, final String fileType, final String fileName) {
        final StringBuilder stringBuilder = new StringBuilder();

        // write the PBM header
        stringBuilder.append("P1\n");
        stringBuilder.append(height).append(" ").append(width).append("\n");

        // write the grid data
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                stringBuilder.append(currentGeneration[row][col] ? "1 " : "0 ");
            }
            stringBuilder.append("\n");
        }
        // forTest = stringBuilder;

        final Path outputFile = Paths.get(m_filePath.toString(),
                fileName + generation + fileType);
        try {
            Files.write(outputFile, stringBuilder.toString().getBytes());
        }
        catch (IOException ex) {
            throw new WriteToFileException(ex);
        }
    }

}
