//Please enter x position of star (1-10) or enter to finish:
//2
//Please enter y position of star: (1-5)
//3
//Please enter shape of star: (a character)
//*
//Please enter x position of star (1-10) or enter to finish:
//9
//Please enter y position of star: (1-5)
//5
//Please enter shape of star: (a character)
//@
//Please enter x position of star (1-10) or enter to finish:
//1
//Please enter y position of star: (1-5)
//4
//Please enter shape of star: (a character)
//#
//Please enter x position of star: (1-10)

//THE STAR MAP
//..........
//..........
//.*........
//#.........
//........@.


import java.util.logging.Level;
import java.util.logging.Logger;

public final class StarMap {
	private static final Logger logger = Logger.getLogger(StarMap.class.getCanonicalName());
	
	private static final int SIZE_Of_MAP = 5;
	
	public static void main(final String[] args) {
	
		Star[][] starsMaps = new Star[SIZE_Of_MAP][SIZE_Of_MAP];
		
		while(true){
		
			try {
			
			logger.log(Level.INFO, "Please enter x position of star (1-5) or enter to finish: ");
			//final String untrust_x = System.console().readLine();
			final int x = Integer.valueOf(System.console().readLine()) - 1;
			
			logger.log(Level.INFO, "Please enter y position of star (1-5) or enter to finish: ");
			final int y = Integer.valueOf(System.console().readLine()) - 1;
			
			logger.log(Level.INFO, "Please enter shape of star: (a character) ");
			final char shapeOfStar = System.console().readLine().charAt(0);
			 
			starsMaps[x][y] = new Star(x , y , shapeOfStar);
			
			} catch (NumberFormatException ex ) {
				logger.log(Level.INFO, "Exit!");
				break;
			} catch (ArrayIndexOutOfBoundsException ex ) {
				logger.log(Level.INFO, "ArrayIndexOutOfBoundsException!");
				break;
			}
		}
		
		logger.log(Level.INFO, "\n--------------------------\n");

		 String starMapToPrint = "\n";
		
		for(Star[] numStarRow : starsMaps) {
			for(Star numStarCol : numStarRow) {
				if (numStarCol != null) {
					starMapToPrint += numStarCol.getShapeOfStar();
				} else {
					starMapToPrint +=  " . ";
				}
				
			}
			starMapToPrint +=  "\n";
		}
		
		logger.log(Level.INFO, starMapToPrint);

	}

	
}
