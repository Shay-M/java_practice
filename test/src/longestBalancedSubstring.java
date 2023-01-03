import java.util.logging.Level;
import java.util.logging.Logger;

public class longestBalancedSubstring {
    private static final Logger logger = Logger.getLogger(longestBalancedSubstring.class.getCanonicalName());

    /*public static int longestBalancedSubstring(String s) {
        int maxLength = 0;
        int ones = 0;
        int zeros = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == '1') {
                ones++;
            }
            else {
                zeros++;
            }
            if (ones == zeros) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            if (ones > zeros) {
                while (i < j && ones > zeros) {
                    if (s.charAt(i) == '1') {
                        ones--;
                    }
                    else {
                        zeros--;
                    }
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }*/

    static int maxLength(final String s) {
        final int stringlength = s.length();
        // As it's subsequence - assuming first
        // open brace would map to a first close
        // brace which occurs after the open brace
        // to make subsequence balanced and second
        // open brace would map to second close
        // brace and so on.

        // Variable to count all the open brace
        // that does not have the corresponding
        // closing brace.
        int oneInvalidBraces = 0;

        // To count all the close brace that
        // does not have the corresponding open brace.
        int zeroInvalidBraces = 0;

        // Iterating over the String
        for (int i = 0; i < stringlength; i++) {
            if (s.charAt(i) == '1') {

                // Number of open braces that
                // hasn't been closed yet.vvvvvv
                oneInvalidBraces++;
            }
            else {
                if (oneInvalidBraces == 0) {

                    // Number of close braces that
                    // cannot be mapped to any open
                    // brace.
                    zeroInvalidBraces++;
                }
                else {

                    // Mapping the ith close brace
                    // to one of the open brace.
                    oneInvalidBraces--;
                }
            }
        }
        return (stringlength - (oneInvalidBraces + zeroInvalidBraces));
    }


    public static void main(final String[] args) {

        logger.log(Level.INFO, "" + maxLength("1111111010101001"));
        logger.log(Level.INFO, "" + maxLength("1100"));
    }
}
