package actionprocessor;

import bundle.TextProcessBundle;

import java.util.List;
import java.util.logging.Level;

public final class Upper implements ProcessorAction {
    @Override
    public String doAction(final TextProcessBundle textProcessBundle) {
        // m_logger.log(Level.INFO, "use " + textProcessBundle.getClass().getName());

        final List<String> chunksOfLines = textProcessBundle.getText();

        for (String line : chunksOfLines) {
            String upperLine = line.toUpperCase();
            textProcessBundle.writeText(upperLine);
        }

        return "String";
    }
}
