import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        final HashMap<String> hashMap = new HashMap<String>(100000);
//        logger.log(Level.INFO, " " + mapLong.isEmpty());
//        logger.log(Level.INFO, " " + mapLong.size());
//        mapLong.put(6L, "gg");
//        logger.log(Level.INFO, " " + mapLong.size());
//        logger.log(Level.INFO, " " + mapLong.getValue(6L));
//        logger.log(Level.INFO, " " + mapLong.contains("gg"));
//        // logger.log(Level.INFO, " "+ mapLong.getValue(5L));

        final SecureRandom secureRandom = new SecureRandom();
        final long startTime = System.nanoTime();
        for (long i = 0; i < 100000; i++) {
            hashMap.put(secureRandom.nextLong(), "hi" + i);
        }
        final long endTime = System.nanoTime();
        logger.log(Level.INFO, "duration: " + (endTime - startTime) / 1000000.0 + " milliseconds");

//        final long startTime = System.nanoTime();
//        logger.log(Level.INFO, " " + mapLong.isEmpty());
//        // logger.log(Level.INFO, " " + mapLong.getValue(6L));
//        final long endTime = System.nanoTime();
//        logger.log(Level.INFO, "isEmpty: " + (endTime - startTime) / 1000000.0 + " milliseconds");

        for (String tru : hashMap ){
            logger.log(Level.INFO, " " + tru);
        }
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