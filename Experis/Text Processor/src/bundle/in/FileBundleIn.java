package bundle.in;

import util.SystemFiles;

import java.nio.file.Path;
import java.util.List;

public final class FileBundleIn implements InputBundle {
    private final Path m_inputFile;

    public FileBundleIn(final Path inputFile) {
        m_inputFile = inputFile;
    }

    @Override
    public List<String> getText() {
        final List<String> chunksOfLines = SystemFiles.readFile(m_inputFile);
        return chunksOfLines;
    }
}
