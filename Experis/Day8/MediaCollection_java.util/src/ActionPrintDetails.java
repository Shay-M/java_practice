import java.util.logging.Level;

public class ActionPrintDetails extends Action {
    private static final String ACTION_NAME = "Print details for books and cds";

    public ActionPrintDetails(Collection mCollection) {
        super(mCollection, ACTION_NAME);
    }

    @Override
    public void doAction() {

        if (m_collection.count() == 0) {
            return;
        }

        ManuManager.getCommandNum(logger, m_collection.count());

        logger.log(Level.INFO, "\nType the beginning of the book/cd name:");
        String prefix = System.console().readLine().toLowerCase().trim();

        if (prefix.equals("")) {
            return;
        }

        StringBuilder outPut = new StringBuilder("\n\t" + ACTION_NAME + "\n");
        int indexCommands = 0;

       /* int[] itemsIds;
        for (Media media : (Iterable<Media>) m_collection) {
            if (media.getName().toLowerCase().trim().startsWith(prefix)) {
                itemsIds[index++] = item.getId();
                outPut.append("\t[").append(media.getLoaned() ? '*' : ' ');
                outPut.append("] ").append(++indexCommands).append(") ");
                outPut.append(" ").append(media.getName());
                outPut.append("\n");
            }
        }*/


        /*for (IRentable item : Collection) {
            if (item != null && item.toString().toLowerCase().startsWith(prefix)) {
                itemsIds[index++] = item.getId();
                outPut.append("\t").append(index).append(") ");
                outPut.append("").append(item);
                outPut.append("\n");
            }
        }*/


        logger.log(Level.INFO, outPut + "Enter number of itemes:");


        /*logger.log(Level.INFO, outPut + "id: " + command);
        return _itemsArr[itemsIds[command - 1]];*/
    }
}

