package bundle;

import util.SystemFiles;

import java.nio.file.Path;
import java.util.List;

public final class FileBundle implements TextProcessBundle {

    final private Path m_inputFile;
    final private Path m_outputFile;
    final SystemFiles m_systemFiles = new SystemFiles();

    public FileBundle(final Path inputFile, final Path outputFile) {
        m_inputFile = inputFile;
        m_outputFile = outputFile;
    }

    @Override
    public void writeText(final String line) {
        m_systemFiles.writeTextToFile(m_outputFile, line);
    }

    @Override
    public List<String> getText() {
        final List<String> chunksOfLines = m_systemFiles.readFile(m_inputFile);
        return chunksOfLines;
    }
}
