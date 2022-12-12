import java.util.logging.Level;
import java.util.logging.Logger;

public class AcPrintAll implements Action {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    private final String actionName = "List all books & cds";
    private Iterator m_iterator;

    public AcPrintAll(Iterator iterator) {

        m_iterator = iterator;
    }


    @Override
    public void doAction() {
       /* while (m_iterator.hasNext()) {
            Media media = (Media) m_iterator.next();
            logger.log(Level.INFO, media.getName());
        }*/

        String outPut = "\n\t" + actionName + "\n";
        int indexCommands = 0;
        while (m_iterator.hasNext()) {
            Media obj = (Media) m_iterator.next();

            outPut += "\t[" + (obj.getLoaned() ? '*' : ' ');
            outPut += "] " + ++indexCommands + ") ";
            outPut += "" + obj.getName() + "";
            outPut += "\n";

        }

        if (indexCommands == 0) {
            outPut += "- There is no media in the library -\n";
        }

        logger.log(Level.INFO, outPut);
    }

    @Override
    public String getName() {
        return actionName;
    }


}
