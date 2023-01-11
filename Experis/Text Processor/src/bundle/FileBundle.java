package bundle;

import util.SystemFiles;

import java.nio.file.Paths;
import java.util.List;

public class FileBundle implements TextProcessBundle {

    final SystemFiles m_systemFiles = new SystemFiles();

    @Override
    public void writeText(final String line) {
        m_systemFiles.writeTextToFile(Paths.get("output.txt"), line);
    }

    @Override
    public List<String> getText() {
        final List<String> chunksOfLines = m_systemFiles.readFile(Paths.get("inPut.txt"));
        return chunksOfLines;
    }
}
