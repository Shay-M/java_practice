import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {

        final List<String> testListOfStrings = new ArrayList<String>();
        for (char ch = 'a'; ch < 'z'; ch++) {
            testListOfStrings.add("" + ch);
        }

        for (char ch = 'a'; ch < 'z'; ch++) {
            for (char ch2 = 'a'; ch2 < 'z'; ch2++) {
                testListOfStrings.add("" + ch + ch2);
            }
        }
        String output = "\n";
        for (String ch : testListOfStrings) {
            output += "\n" + ch + " ---> hashCode: " + ch.hashCode();
        }
        logger.log(Level.INFO, output);

    }
}