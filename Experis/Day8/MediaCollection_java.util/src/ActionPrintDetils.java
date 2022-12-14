import java.util.logging.Level;

public class ActionPrintDetils extends Action {
    private static final String ACTION_NAME = "Print details for books and cds";

    public ActionPrintDetils(Collection mCollection) {
        super(mCollection, ACTION_NAME);

    }

    @Override
    public void doAction() {

        try {
            logger.log(Level.INFO, "\n\n\tItem Details: " + ((Media) m_collection.at(0)).getName() + "\n");

        } catch (NullPointerException ex) {
            logger.log(Level.INFO, "\n no Item found!\n");
        }
    }

    /*private final IRentable getItemByUser() {

        int itemsArraylength = _itemsArr.length;

        if (itemsArraylength == 0) {
            return null;
        }

        logger.log(Level.INFO, "\nType the beginning of the book/cd name:");
        String prefix = System.console().readLine().toLowerCase();

        if (prefix.equals("")) {
            return null;
        }

        String outPut = "\n\n";

        int index = 0;
        int command = 0;

        int[] itemsIds = new int[itemsArraylength];

        for (IRentable item : _itemsArr) {
            if (item != null && item.toString().toLowerCase().startsWith(prefix)) {
                itemsIds[index++] = item.getId();
                outPut += "\t" + index + ") ";
                outPut += "" + item + "";
                outPut += "\n";
            }
        }

        logger.log(Level.INFO, outPut + "Enter number of itemes:");

        try {
            command = Integer.valueOf(System.console().readLine()) ;

        } catch (NumberFormatException ex) {
            logger.log(Level.INFO, "Exit!");
            return null;
        }

        logger.log(Level.INFO, outPut + "id: " + command);
        return _itemsArr[itemsIds[command - 1]];
    }*/

}
