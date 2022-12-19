import Collection.*;

import java.util.logging.Level;
import java.util.logging.Logger;

//  logger.setLevel(Level.FINEST);
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        // testAll();

        Collection<OutputableMedia> mediaCollection = initializeMedia();
        Collection<Action> actionsCollection = initializeAction(mediaCollection);
        printAction(actionsCollection);

        /*
        final int commandNum = ManuManager.getCommandNum(logger, actionsCollection.count());
        //actionsCollection.at(commandNum).doAction();

        actionsCollection.at(0).doAction();
        actionsCollection.at(1).doAction();
        */
    }


    private static void printAction(Collection<Action> actionsCollection) {
        int indexCommands = 1;
        String outPut = "\nChoose one of the options (1-" + actionsCollection.count() + "), any other key to exit.\n";

        for (Action action : actionsCollection) {
            outPut += "\t" + indexCommands++ + ") ";
            outPut += action.getName();
            outPut += "\n";
        }
        logger.log(Level.INFO, outPut);
    }

    private static Collection<Action> initializeAction(Collection<OutputableMedia> mediaCollection) {
        Collection<Action> actionsCollection = new ArrayCollection<Action>(); // actions.printAll; ?
        actionsCollection.add(new ActionPrintAll(mediaCollection));
        actionsCollection.add(new ActionPrintDetails(mediaCollection));
        return actionsCollection;
    }

    private static Collection<OutputableMedia> initializeMedia() {

        //Collection.Collection<Media> mediaCollection = new Collection.LinkedCollection<Media>();
        Collection<OutputableMedia> mediaCollection = new ArrayCollection<OutputableMedia>();
        mediaCollection.add(new Book("1 Harry Potter", "J.K.Rolling"));
        mediaCollection.add(new Cd("2 Jungle Book", "Kipling", true));
        mediaCollection.add(new Cd("3 The Little Prince", "Anton", false));
        /*for (Media media : mediaCollection) {
            logger.log(Level.INFO, "media: " + media.getName());
        }*/
        return mediaCollection;
    }

    private static void testAll() {
        testWithACollectionOfMedia();
        testWithACollectionOfLong();
        testWithACollectionOfLoaned();
        testWithACollectionOfString();
        testWithACollectionOfInteger();
        /*logger.log(Level.INFO, " " + mediaCollection.at(0).equals(mediaCollection.at(0)));
        logger.log(Level.INFO, " " + mediaCollection.at(0).equals(mediaCollection.at(1)));*/

        // 3) Can you have a collection of int? (the primitive, not the reference type Integer)
        // no bcz int not a obj

        /*// 4) Can you add different types to the Collection.Collection? (for example, both String and Media in the same collection:Collection.Collection c = new Collection.Collection.ArrayCollection();
        // yes they are all obj

        Collection.Collection collection = new Collection.Collection.ArrayCollection();
        collection.insert(new String("0L"));
        collection.insert(new Long(2L));
        collection.insert(new Media("Harry Potter", "J K Rolling"));

        // If yes - how can you print all the items in the collection? If no - why?
        // instanceof and collection ot try */
    }

    private static void testWithACollectionOfInteger() {
        logger.log(Level.INFO, "\n\n");

        Collection<Integer> collectionLong = new ArrayCollection<Integer>();
        collectionLong.add(0);
        collectionLong.add(2);
        collectionLong.add(5);

        for (Integer num : collectionLong) {
            //Object num = itr.next();
            logger.log(Level.INFO, "Integer: " + num.toString());
        }
    }

    @SuppressWarnings("removal")
    private static void testWithACollectionOfLong() {
        logger.log(Level.INFO, "\n\n");
        Collection<Long> collectionLong = new ArrayCollection<Long>(); //Collection.Collection.ArrayCollection!! insert
        collectionLong.add(0L);
        collectionLong.add(2L);
        collectionLong.add(new Long(5L));

        /*java.util.Iterator<Long> itr = collectionLong.iterator();
        while (itr.hasNext()) {
            Long num = itr.next();
            //Object num = itr.next();
            logger.log(Level.INFO, "Long: " + num.toString());
        }*/

        for (Long num : collectionLong) {
            //Object num = itr.next();
            logger.log(Level.INFO, "Long: " + num.toString());
        }
    }

    private static void testWithACollectionOfString() {
        logger.log(Level.INFO, "\n\n");

        Collection<String> collection = new LinkedCollection();
        collection.insert("1 Harry Potter");
        collection.insert("2 Jungle Book");
        collection.insert("3 The Little Prince");

        for (String str : collection) {
            //Object num = itr.next();
            logger.log(Level.INFO, "Long: " + str);
        }
    }

    private static void testWithACollectionOfLoaned() {
        logger.log(Level.INFO, "\n\n");
        Collection<Media> collectionMedia = new ArrayCollection<Media>();
        collectionMedia.insert(new Media("1 Harry Potter", "J.K.Rolling", false));
        collectionMedia.insert(new Media("2 Jungle Book", "Kipling", false));
        collectionMedia.insert(new Media("3 The Little Prince", "Anton", false));

        Collection collectionLoaned = new ArrayCollection();

        collectionLoaned.add(new Loaned(new Media("1 Harry Potter", "J.K.Rolling", false), "Yoel"));
        collectionLoaned.add(new Loaned(collectionMedia.at(1), "Riv"));

        for (Loaned loaned : (Iterable<Loaned>) collectionLoaned) {
            logger.log(Level.INFO, (loaned).getObj().getName() +
                    " loaned to " + (loaned).loanedTo());
        }
    }

    private static void testWithACollectionOfMedia() {
        logger.log(Level.INFO, "\n\n");
        //Collection.Collection collectionMedia = new Collection.Collection.ArrayCollection();
        Collection<Media> collectionMedia = new ArrayCollection<Media>();
        collectionMedia.insert(new Media("1 Harry Potter", "J.K.Rolling", false));
        collectionMedia.insert(new Media("2 Jungle Book", "Kipling", false));
        collectionMedia.insert(new Media("3 The Little Prince", "Anton", false));

        java.util.Iterator<Media> itr = collectionMedia.iterator();
        while (itr.hasNext()) {
            Media media = itr.next();
            logger.log(Level.INFO, (media).getName());
        }

        logger.log(Level.INFO, "mc.count(): " + collectionMedia.count());
        logger.log(Level.INFO, "\n");
        logger.log(Level.INFO, "mc.at(0).getName(): " + ((Media) collectionMedia.at(0)).getName());
        logger.log(Level.INFO, "\n");

        logger.log(Level.INFO, "\n");
        collectionMedia.removeAt(2); // removeAt
        logger.log(Level.INFO, "mc.count(): " + collectionMedia.count());

        logger.log(Level.INFO, "\n");

        itr = collectionMedia.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            logger.log(Level.INFO, ((Media) obj).getName());
        }

        logger.log(Level.INFO, "\n");

        collectionMedia.add(new Media("4  Little Prince", "Anton", false));

        itr = collectionMedia.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            logger.log(Level.INFO, ((Media) obj).getName());
        }
    }

}