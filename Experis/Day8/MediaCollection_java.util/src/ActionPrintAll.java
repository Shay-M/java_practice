import java.util.logging.Level;

public class ActionPrintAll extends Action {

    private static final String ACTION_NAME = "List all books & cds";

    public ActionPrintAll(Collection collection) {
        super(collection, ACTION_NAME);
    }

    @Override
    public void doAction() {

        String outPut = "\n\t" + ACTION_NAME + "\n";
        int indexCommands = 0;

        final java.util.Iterator m_iterator = m_collection.iterator();

        while (m_iterator.hasNext()) {
            Media obj = (Media) m_iterator.next();

            outPut += "\t[" + (obj.getLoaned() ? '*' : ' ');
            outPut += "] " + ++indexCommands + ") ";
            outPut += "" + obj.getName() + "";
            outPut += "\n";

        }
/*
        for (Media media : m_collection) {
            outPut += "\t[" + (media.getLoaned() ? '*' : ' ');
            outPut += "] " + ++indexCommands + ") ";
            outPut += "" + media.getName() + "";
            outPut += "\n";
    }
        
        if(indexCommands ==0)

    {
        outPut += "- There is no media in the library -\n";
    }

        logger.log(Level.INFO,outPut);*/
    }


}



