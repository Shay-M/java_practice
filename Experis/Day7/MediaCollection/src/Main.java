import java.util.logging.Level;
import java.util.logging.Logger;

//  logger.setLevel(Level.FINEST);
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        testAll();
        //Collection<Media> mediaCollection = new LinkedCollection<Media>();
        Collection<Media> mediaCollection = new ArrayCollection<Media>();
        mediaCollection.insert(new Media("1 Harry Potter", "J.K.Rolling", false)); //todo combine
        mediaCollection.insert(new Media("2 Jungle Book", "Kipling", true));
        mediaCollection.insert(new Media("3 The Little Prince", "Anton", false));


        Collection<Action> actions = new ArrayCollection<Action>(); // actions.printAll; ?
        actions.add(new ActionPrintAll(mediaCollection));
        actions.add(new ActionPrintDetils(mediaCollection));


        //while (true) {

        try {
            //final int commandNum = Integer.valueOf(System.console().readLine()) - 1;

            ((Action) actions.at(0)).doAction();
            ((Action) actions.at(1)).doAction();

        } catch (NumberFormatException ex) {
            logger.log(Level.INFO, "Exit!");
            return;
        }

    }

    private static void testAll() {

        testWithACollectionOfMedia();
        testWithACollectionOfLong();
        testWithACollectionOfLoaned();
        testWithACollectionOfString();

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


    @SuppressWarnings("removal")
    private static void testWithACollectionOfLong() {
        logger.log(Level.INFO, "\n\n");

        Collection<Long> collectionLong = new ArrayCollection<Long>(); //ArrayCollection!! insert
        collectionLong.add(0L);
        collectionLong.add(2L);
        collectionLong.add(new Long(5L));

        Iterator<Long> itr = collectionLong.iterator();
        while (itr.hasNext()) {
            Long num = itr.next();
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

        Iterator<String> itr = collection.iterator();

        while (itr.hasNext()) {
            String str = itr.next();
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

        Iterator<Loaned> itr = collectionLoaned.iterator();
        while (itr.hasNext()) {
            Loaned loaned = itr.next();
            logger.log(Level.INFO, (loaned).getObj().getName() +
                    " loaned to " + (loaned).loanedTo());

        }
    }

    private static void testWithACollectionOfMedia() {

        logger.log(Level.INFO, "\n\n");

        //Collection collectionMedia = new ArrayCollection();
        Collection<Media> collectionMedia = new ArrayCollection<Media>();
        collectionMedia.insert(new Media("1 Harry Potter", "J.K.Rolling", false));
        collectionMedia.insert(new Media("2 Jungle Book", "Kipling", false));
        collectionMedia.insert(new Media("3 The Little Prince", "Anton", false));

        Iterator<Media> itr = collectionMedia.iterator();

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