package actionprocessor;

import bundle.in.InputBundle;
import bundle.out.OutputBundle;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Upper implements ProcessorAction {
    final private Logger m_logger;

    public Upper(final Logger logger) {
        m_logger = logger;
    }

    @Override
    public void doAction(final InputBundle inputBundle, final OutputBundle outputBundle) {
        m_logger.log(Level.INFO, "doAction ");

        final List<String> chunksOfLines = inputBundle.getText();

        for (String line : chunksOfLines) {
            String upperLine = line.toUpperCase();
            outputBundle.writeText(upperLine);
        }


    }
}
