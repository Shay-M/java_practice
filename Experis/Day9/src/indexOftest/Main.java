package indexOftest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        final List<String> l1 = new ArrayList<String>();
        l1.add("Hello");
        l1.add("Goodbye");

        int idxFound = l1.indexOf("Hello");
        logger.log(Level.INFO, String.valueOf(idxFound));

        idxFound = l1.indexOf("hello");
        logger.log(Level.INFO, String.valueOf(idxFound));

        final List<Book> books = new ArrayList<Book>(); // book is from the BookCd example
        final Book b1 = new Book("Harry Potter", "JK Rolling");
        final Book b2 = new Book("Jungle Book", "Kipling");
        books.add(b1);
        books.add(b2);


        idxFound = books.indexOf(b1);

        logger.log(Level.INFO, String.valueOf(idxFound)); // IS THE OUTPUT WHAT YOU EXPECTED? WHY?

        idxFound = books.indexOf(b2);
        logger.log(Level.INFO, String.valueOf(idxFound)); // IS THE OUTPUT WHAT YOU EXPECTED? WHY?

        final Book similarToB1 = new Book("Harry Potter", "JK Rolling");
        idxFound = books.indexOf(similarToB1);
        logger.log(Level.INFO, String.valueOf(idxFound)); // IS THE OUTPUT WHAT YOU EXPECTED? WHY?

    }
}
