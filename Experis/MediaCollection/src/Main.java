import java.util.logging.Level;
import java.util.logging.Logger;

//  logger.setLevel(Level.FINEST);
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {

        testAll();

        Collection mediaCollection = new LinkedCollection();
        mediaCollection.insert(new Media("1 Harry Potter", "J.K.Rolling", false));//todo
        mediaCollection.insert(new Media("2 Jungle Book", "Kipling", true));
        mediaCollection.insert(new Media("3 The Little Prince", "Anton", false));

        Collection actions = new ArrayCollection(); // actions.printAll; ?
        actions.add(new AcPrintAll(mediaCollection));
        actions.add(new AcPrintDetils(mediaCollection));


        //while (true) {

        try {
            //final int commandNum = Integer.valueOf(System.console().readLine()) - 1;

            ((Action) actions.at(0)).doAction(); //r need?
            ((Action) actions.at(1)).doAction(); //r

        } catch (NumberFormatException ex) {
            logger.log(Level.INFO, "Exit!");
            return;
        }
        //}
    }


    private static void testWithACollectionOfLoaned() {
        Collection collection = new ArrayCollection();
        collection.insert(new Media("1 Harry Potter", "J.K.Rolling", false));
        collection.insert(new Media("2 Jungle Book", "Kipling", false));
        collection.insert(new Media("3 The Little Prince", "Anton", false));

        Collection collection2 = new ArrayCollection();
        //Collection collection2 = new LinkedCollection();

        collection2.add(new Loaned(new Media("1 Harry Potter", "J.K.Rolling", false), "Yoel"));
        collection2.add(new Loaned(collection.at(1), "Riv"));

        Iterator itr = collection2.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            logger.log(Level.INFO, ((Loaned) obj).getObj().getName() +
                    " loaned to " + ((Loaned) obj).loanedTo());

        }
    }

    private static void testWithACollectionOfMedia() {

        //Collection collection = new ArrayCollection();
        Collection collection = new LinkedCollection();

        collection.insert(new Media("1 Harry Potter", "J.K.Rolling", false));
        collection.insert(new Media("2 Jungle Book", "Kipling", false));
        collection.insert(new Media("3 The Little Prince", "Anton", false));

        Iterator itr = collection.iterator();

        while (itr.hasNext()) {
            Object obj = itr.next();
            logger.log(Level.INFO, ((Media) obj).getName());
        }

        logger.log(Level.INFO, "mc.count(): " + collection.count());
        logger.log(Level.INFO, "\n");
        logger.log(Level.INFO, "mc.at(0).getName(): " + ((Media) collection.at(0)).getName());
        logger.log(Level.INFO, "\n");

        logger.log(Level.INFO, "\n");
        collection.removeAt(2); // removeAt
        logger.log(Level.INFO, "mc.count(): " + collection.count());

        logger.log(Level.INFO, "\n");

        itr = collection.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            logger.log(Level.INFO, ((Media) obj).getName());
        }

        logger.log(Level.INFO, "\n");

        collection.add(new Media("4  Little Prince", "Anton", false));

        itr = collection.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            logger.log(Level.INFO, ((Media) obj).getName());
        }
    }

    private static void testAll() {

        //testWithACollectionOfMedia();
        //testWithACollectionOfLoaned();

        // ------------------------Test with a collection of String.---------------------------

       /* Collection collection = new ArrayCollection();
        collection.insert(new String("1 Harry Potter"));
        collection.insert(new String("2 Jungle Book"));
        collection.insert(new String("3 The Little Prince"));

        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            logger.log(Level.INFO, "String: " + ((String) obj).toUpperCase());

        }*/

        // ------------------------Test with a collection of Long.---------------------------

        /*Collection collection = new ArrayCollection();
        collection.insert(new Long(0L));
        collection.insert(new Long(2L));
        collection.insert(new Long(5L));

        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            logger.log(Level.INFO, "Long: " + ((Long) obj).toString());

        }*/

        // 3) Can you have a collection of int? (the primitive, not the reference type Integer)
        // no bcz int not a obj


        /*// 4) Can you add different types to the Collection? (for example, both String and Media in the same collection:Collection c = new ArrayCollection();
        // yes they r all obj
        Collection collection = new ArrayCollection();
        collection.insert(new String("0L"));
        collection.insert(new Long(2L));
        collection.insert(new Media("Harry Potter", "J K Rolling"));

        // If yes - how can you print all the items in the collection? If no - why?
        // instanceof and not fun way*/


    }


}