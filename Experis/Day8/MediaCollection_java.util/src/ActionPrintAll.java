import Collection.Collection;

import java.util.logging.Level;

public class ActionPrintAll<T> extends Action {

    private static final String ACTION_NAME = "List all books & cds";

    public ActionPrintAll(Collection<T> collection) {
        super(collection, ACTION_NAME);
    }

    @Override
    public void doAction() {

        StringBuilder outPut = new StringBuilder("\n\t" + ACTION_NAME + "\n");
        int indexCommands = 0;

        for (Media media : (Iterable<OutputableMedia>) m_collection) { //<<
            outPut.append("\t[").append(media.getLoaned() ? '*' : ' ');
            outPut.append("] ").append(++indexCommands).append(") ");
            outPut.append(" ").append(media.getName());
            outPut.append("\n");
        }


        if (indexCommands == 0) {
            outPut.append("- There is no media in the library -\n");
        }

        logger.log(Level.INFO, outPut.toString());
    }


}



