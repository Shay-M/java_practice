import java.util.logging.Level;
import java.util.logging.Logger;

public class BookPrinter extends MediaPrinter {
    @Override
    public void output(Logger logger, Media media) {
        final StringBuilder stringOutPut = new StringBuilder("\n");
        int indexCommands = 0;
        stringOutPut.append("\t[").append(media.getLoaned() ? LoanedState.Loaned.yes : LoanedState.Loaned.no);
        stringOutPut.append("] ").append(++indexCommands).append(") ");
        stringOutPut.append(" ").append(media.getName());
        stringOutPut.append("\n");
        logger.log(Level.INFO, String.valueOf(stringOutPut));
    }

//        for (IRentable item : Collection.Collection) {
//            if (item != null && item.toString().toLowerCase().startsWith(prefix)) {
//                itemsIds[index++] = item.getId();
//                stringOutPut.append("\t").append(index).append(") ");
//                stringOutPut.append("").append(item);
//                stringOutPut.append("\n");
//            }
//        }
}
