import java.util.logging.Level;
import java.util.logging.Logger;

public class longestBalancedSubstring {
    private static final Logger logger = Logger.getLogger(longestBalancedSubstring.class.getCanonicalName());

    public static int longestBalancedSubstring(String s) {
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
    }


    public static void main(final String[] args) {

        logger.log(Level.INFO, "" + longestBalancedSubstring("1111111010101001"));
    }
}
