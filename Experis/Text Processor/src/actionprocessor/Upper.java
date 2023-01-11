package actionprocessor;

import bundle.TextProcessBundle;

import java.util.List;

public class Upper implements ProssessorAction {
    @Override
    public String doAction(final TextProcessBundle textProcessBundle) {

        final List<String> chunksOfLines = textProcessBundle.getText();

        for (String line : chunksOfLines) {
            String upperLine = line.toUpperCase();
            textProcessBundle.writeText(upperLine);
        }

        return "String";
    }
}
