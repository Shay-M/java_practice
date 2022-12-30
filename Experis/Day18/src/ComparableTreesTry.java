import java.util.logging.Level;
import java.util.logging.Logger;

public final class ComparableTreesTry {
    private static final Logger logger = Logger.getLogger(ComparableTreesTry.class.getCanonicalName());

    // https://www.geeksforgeeks.org/why-to-use-comparator-interface-rather-than-comparable-interface-in-java/?ref=rp
    public final static class X implements Comparable<X> {
        private int happyInt;

        public X() {
            happyInt = 666;
        }

        public void setDateTimeCreated(final int newHappyInt) {
            this.happyInt = newHappyInt;
        }


        @Override
        public int compareTo(X o) { //?
            return (o.happyInt) - (this.happyInt);
        }
    }

    public static void main(final String[] args) {
        final ComparableTree<X> xTree = new ComparableTree<X>();
        final X x = new X();
        final X y = new X();
        xTree.add(x);
        xTree.add(y);


        logger.log(Level.INFO, "" + xTree.get(x));
        xTree.remove(x);
        logger.log(Level.INFO, "after remove: " + xTree.get(x));

        xTree.add(x);
        logger.log(Level.INFO, "" + xTree.get(x)); //null

        //xTree.get(x).setDateTimeCreated(1);
        //logger.log(Level.INFO, "after change: " + xTree.get(x));
//        xTree.remove(x);
//        logger.log(Level.INFO, "after remove: " + xTree.get(x));


    }
}
