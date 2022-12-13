import java.util.logging.Level;
import java.util.logging.Logger;

//  logger.setLevel(Level.FINEST);
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        //testAll();

        Collection<Media> mediaCollection = new LinkedCollection<Media>();
        //Collection<Media> mediaCollection = new ArrayCollection<Media>();
        mediaCollection.insert(new Media("1 Harry Potter", "J.K.Rolling", false)); //todo combine
        mediaCollection.insert(new Media("2 Jungle Book", "Kipling", true));
        mediaCollection.insert(new Media("3 The Little Prince", "Anton", false));

        /*Iterator<Media> itr = mediaCollection.iterator();
        while (itr.hasNext()) {
            final Media media = itr.next();
            logger.log(Level.INFO, ">>: " + media.getName());
        }*/

        Collection<Action> actions = new ArrayCollection<Action>(); // actions.printAll; ?
        actions.add(new ActionPrintAll(mediaCollection));
        actions.add(new ActionPrintDetils(mediaCollection));
        actions.add(new ActionPrintDetils(mediaCollection));
        actions.add(new ActionPrintDetils(mediaCollection));
        actions.add(new ActionPrintDetils(mediaCollection));

        //while (true) {

        try {
            //final int commandNum = Integer.valueOf(System.console().readLine()) - 1;

            ((Action) actions.at(0)).doAction(); //r need?
            ((Action) actions.at(1)).doAction(); //r

        } catch (NumberFormatException ex) {
            logger.log(Level.INFO, "Exit!");
            return;
        }

    }

    private static void testAll() {

        /*testWithACollectionOfMedia();
        testWithACollectionOfLoaned();
        testWithACollectionOfString();
        testWithACollectionOfLong();*/

        // 3) Can you have a collection of int? (the primitive, not the reference type Integer)
        // no bcz int not a obj

        /*// 4) Can you add different types to the Collection? (for example, both String and Media in the same collection:Collection c = new ArrayCollection();
        // yes they are all obj

        Collection collection = new ArrayCollection();
        collection.insert(new String("0L"));
        collection.insert(new Long(2L));
        collection.insert(new Media("Harry Potter", "J K Rolling"));

        // If yes - how can you print all the items in the collection? If no - why?
        // instanceof and collection */


    }
/*

    @SuppressWarnings("removal")
    private static void testWithACollectionOfLong() {
        Collection<Long> collectionLong = new ArrayCollection<Long>(); //ArrayCollection!! insert
        collectionLong.add(new Long(0L));
        collectionLong.add(new Long(2L));
        collectionLong.add(new Long(5L));

        Iterator<Long> itr = collectionLong.iterator();
        while (itr.hasNext()) {
            Long num = itr.next();
            //Object num = itr.next();
            logger.log(Level.INFO, "Long: " + num.toString());

        }
    }

    private static void testWithACollectionOfString() {
        Collection<String> collection = new LinkedCollection();
        collection.insert("1 Harry Potter");
        collection.insert("2 Jungle Book");
        collection.insert("3 The Little Prince");

        Iterator<String> itr = collection.iterator();

        while (itr.hasNext()) {
            String num = itr.next();
            //Object num = itr.next();
            logger.log(Level.INFO, "Long: " + num.toString());

        }
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

    */


}