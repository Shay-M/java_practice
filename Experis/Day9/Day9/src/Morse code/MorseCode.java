import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.LinkedList;

public class MorseCode {

    private static final Logger logger = Logger.getLogger(MorseCode.class.getCanonicalName());
	
	private static final String[] morseCodeLaters = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
	".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	// private static final String[] morseCodeNumbers = {".----","..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.","-----"};
	
	
	public static void main(String[] args) {
		
		final String inputText = String.join(" ", args).toUpperCase();
		
		final LinkedList<Character> listSpaceChr = new LinkedList<Character>();
		listSpaceChr.add(' ');
		listSpaceChr.add('.');
		listSpaceChr.add(',');
		listSpaceChr.add('-');
		listSpaceChr.add(';');
	
		String output = "\n";
		
		
		for (char c : inputText.toCharArray()) {
				
			try{	
				output += morseCodeLaters[(int)c - 65]; //change to - 'A'
			}
			catch (ArrayIndexOutOfBoundsException ex){
				if (listSpaceChr.contains(c)) {
					output += "  ";
				}
			}
			
		}

		logger.log(Level.INFO, "" + output );
		
		
	}
	
	
}