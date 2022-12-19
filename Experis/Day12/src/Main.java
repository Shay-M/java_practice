import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        final MapLong<String> mapLong = new MapLong<String>();
        logger.log(Level.INFO, " " + mapLong.isEmpty());
        logger.log(Level.INFO, " " + mapLong.size());
        mapLong.put(6L, "gg");
        logger.log(Level.INFO, " " + mapLong.size());
        logger.log(Level.INFO, " " + mapLong.getValue(6L));
        logger.log(Level.INFO, " " + mapLong.contains("gg"));
        // logger.log(Level.INFO, " "+ mapLong.getValue(5L));

        for (long i = 0; i < 100000; i++) {
            mapLong.put(6L, "key_" + i);
        }

        long startTime = System.nanoTime();
         logger.log(Level.INFO, " " + mapLong.isEmpty()); //<< 1ms
        // logger.log(Level.INFO, " " + mapLong.getValue(6L)); //<< 1ms
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        logger.log(Level.INFO, "isEmpty: " + duration / 1000000.0 + " milliseconds");
    }
}


//After your done - claculate the Complexity of eachmethod.
//Insert 100000 items into the map and time inserting the next 100000 and gettingavalue.
//Here's how you time the execution of amethod:
//long startTime = System.nanoTime();
//methodToTime();
//long endTime = System.nanoTime();

//long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
//To generate 200000 key values you need a way to generate random values.
//Read about SecureRandom: https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html 
//***After that - create another Map implementation but this times keep the long keys SORTED (so every time you put something in the map the key will be inserted into the sorted location).
//How does this change the Complexity of put/get?
//Redo the timing of methods to see if your complexity calculaitions are correct.
//האם המחלקות שכתבתם מפירות single responsibility? (כנראה שכן)
//רמז: אם תעשו הפרדה נכונה לא תצטרכו copy paste בשביל להוסיף מפה שבה המפתחות ממוינים