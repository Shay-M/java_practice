import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trees {
    private static final Logger logger = Logger.getLogger(Trees.class.getCanonicalName());

    public final static class X implements Comparable<X> {
        private final LocalDateTime dateTimeCreated;//= LocalDateTime.now();

        public X() {
            dateTimeCreated = LocalDateTime.now();
        }

        @Override
        public int compareTo(X o) {

            return (o.dateTimeCreated).compareTo(this.dateTimeCreated);
        }
    }

    public static void main(final String[] args) {
        final Tree<X> xTree = new Tree<X>();
        final X x = new X();
        final X y = new X();
        xTree.add(x);
        xTree.add(y);
        xTree.add(new X());

        logger.log(Level.INFO, "" + xTree.contains(x));
        logger.log(Level.INFO, "" + xTree.contains(new X()));

    }
}
