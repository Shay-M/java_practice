package bundle.out;

import util.SystemFiles;

import java.nio.file.Path;
import java.util.List;

public final class FileBundleOut implements OutputBundle {

    final private Path m_outputFile;
    final SystemFiles m_systemFiles = new SystemFiles();

    public FileBundleOut(final Path outputFile) {
        m_outputFile = outputFile;
    }

    @Override
    public void writeText(final String line) {
        m_systemFiles.writeTextToFile(m_outputFile, line);
    }

}
