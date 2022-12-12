import java.util.logging.Level;
import java.util.logging.Logger;

//  logger.setLevel(Level.FINEST);
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {

        //MediaCollection mc = new ArrayMediaCollection();
        Collection mc = new LinkedCollection();

        mc.insert(new Media("1 Harry Potter", "J.K.Rolling"));
        mc.insert(new Media("2 Jungle Book", "Kipling"));
        mc.insert(new Media("3 The Little Prince", "Anton"));
        Iterator itr = mc.iterator();

        while (itr.hasNext()) {
            Media media = itr.next();
            logger.log(Level.INFO, media.getName());
        }
        /*
        logger.log(Level.INFO, "\n");
        logger.log(Level.INFO, "mc.at(0).getName(): " + mc.at(0).getName());
        logger.log(Level.INFO, "\n");

        logger.log(Level.INFO, "\n");
        mc.removeAt(2); // removeAt
        logger.log(Level.INFO, "mc.count(): " + mc.count());

        logger.log(Level.INFO, "\n");

        itr = mc.iterator();
        while (itr.hasNext()) {
            Media media = itr.next();
            logger.log(Level.INFO, media.getName());
        }

        logger.log(Level.INFO, "\n");

        mc.add(new Media("4  Little Prince", "Anton"));

        itr = mc.iterator();
        while (itr.hasNext()) {
            Media media = itr.next();
            logger.log(Level.INFO, media.getName());
        }*/

        // ---------------------------------------------------


        /*LoanedCollection loaned = new ArrayLoanedCollection();
        loaned.add(new Loaned(mc.at(1), "Yoel"));
        loaned.add(new Loaned(mc.at(2), "Rivit"));

        LoanedIterator itr = loaned.iterator();
        while (itr.hasNext()) {
            Loaned loaned = itr.next();
            logger.log(Level.INFO, loaned.getMedia().getName() + " loaned to " + loaned.loanedTo());

        }*/


    }

}