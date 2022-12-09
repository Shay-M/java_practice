
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HomeLibrary {
    private static final Logger logger = Logger.getLogger(HomeLibrary.class.getCanonicalName());

    private static final int NUM_COMMANDS = 6;
    private static final int NUM_Of_ITMES = 10;
	
	private static final String YES = "y";
	
	private static int numOfBooksAndCds = 0; // todo

    public static void main(final String[] args) {
		
		final IRentable[] library = new IRentable[NUM_Of_ITMES]; // todo calss
		
		library[0] = new Book ("bookTitle" , "bookAuthor" , 0);
		library[1]  = new Cd ("cdTitle" , false , "bandOrSinger" , 1); 
		
		while(true){
			
	        printManu();
			
	        try {
	           final int command = Integer.valueOf(System.console().readLine());
			   
			   switch (command) {
	            case 1:
	                printAllItmes(library);
	                break;
	            case 2:
	                PrintDetailsForItmes(library);
	                break;
	            case 3:
	                AddBook(library);
	                break;
	            case 4:
	                AddCD(library);
	                break;
	            case 5:
	                MarkBookOrCdAsLoaned(library);
	                break;
	            case 6:
	                MarkBookOrCdAsReturned(library);
	                break;
	            default:
	               logger.log(Level.INFO, "Exit!");
				   return;
	        	}
	
	        } catch (NumberFormatException ex) {
	            logger.log(Level.INFO, "Exit!");
				return;
	        }
			

	        logger.log(Level.INFO, "\n--------------------------\n");
		}

    }
	
	private static final void printAllItmes(IRentable[] library) {
		logger.log(Level.INFO, "\n");
		
		String outPut = "\n\n";
		int indexCommands = 0;
		
        for (IRentable itme : library) {
			if (itme != null) {
				outPut += "\t[" + (itme.getLoaned() ? '*' : ' ');
				outPut += "] " + ++indexCommands + ") ";
            	outPut += "" + itme + "";
            	outPut += "\n";
			}
        }

        logger.log(Level.INFO, outPut);
        outPut = "\n";
	
	}
	
	
	private static final IRentable getItmeByUser(IRentable[] library) {
	
		logger.log(Level.INFO, "\nType the begining of the book/cd name:");
		String itemTitle = System.console().readLine().toLowerCase();
		
		String outPut = "\n\n";
		
		int index = 0;
		int command = 0;
		
		int[] itmesIds = new int[NUM_Of_ITMES];
		
        for (IRentable itme : library) {
			if (itme != null && itme.toString().toLowerCase().startsWith(itemTitle)) {
				itmesIds[index++] = itme.getId();
				outPut += "\t" + index + ") ";
            	outPut += "" + itme + "";
            	outPut += "\n";
			}
        }	
		
		logger.log(Level.INFO, outPut + "Enter number of itemes:");
		
		try {
	           	command = Integer.valueOf(System.console().readLine()) ;
	
	        } catch (NumberFormatException ex) {
	            logger.log(Level.INFO, "Exit!");
				return null;
	        }
			
		logger.log(Level.INFO, outPut + "command: " + command);
		return library[itmesIds[command  - 1]];
	}
	private static final void PrintDetailsForItmes(IRentable[] library) {
	
		logger.log(Level.INFO, "\n\n\tItme Details: " + getItmeByUser(library).getDetails() + "\n");		
	}
	
	private static final void AddBook(IRentable[] library) {
		
		logger.log(Level.INFO, "\nWhat is the book title?");
		String bookTitle = System.console().readLine();
		
		logger.log(Level.INFO, "Who is the author?");
		String bookAuthor = System.console().readLine();
		
		library[numOfBooksAndCds] = new Book (bookTitle , bookAuthor , numOfBooksAndCds++);
		
//		logger.log(Level.INFO, " "+ library[0].toString().toLowerCase()); 
//		logger.log(Level.INFO, " "+ library[0].toString().toLowerCase().indexOf(0)); 
//		logger.log(Level.INFO, Boolean.toString(library[0].toString().toLowerCase().startsWith("a"))); 
		
		logger.log(Level.INFO, "\tBook: " + bookTitle + " Added !\n");

	}
	
	private static final void AddCD(IRentable[] library) {
	
		logger.log(Level.INFO, "\nWhat is the cd title?");
		String cdTitle = System.console().readLine();
		
		logger.log(Level.INFO, "Is this an original cd?");
		
		boolean cdOriginal = System.console().readLine().equals(YES) ? true : false; //todo
		
		logger.log(Level.INFO, "Who is the band/singer?");
		String bandOrSinger = System.console().readLine();
		
		// (String title, boolean isOriginal , String bandOrSinger)
		library[numOfBooksAndCds] = new Cd (cdTitle , cdOriginal , bandOrSinger , numOfBooksAndCds++);
		
		logger.log(Level.INFO, "\tCd Added !\n");
	}
	
	private static final void MarkBookOrCdAsLoaned(IRentable[] library) {
	
		getItmeByUser(library).setLoaned(true);
		
		logger.log(Level.INFO, "\n\tBook is loaned! ");	
	}
	
	private static final void MarkBookOrCdAsReturned(IRentable[] library) {
		getItmeByUser(library).setLoaned(false);
		
		logger.log(Level.INFO, "\n\tBook is return! ");	
	}

    private static final void printManu() {

        String[] menuCommands = new String[NUM_COMMANDS];
        String outPut = "\n";

        int indexCommands = 0;
        menuCommands[indexCommands++] = "List all books & cds";
        menuCommands[indexCommands++] = "Print details for books and cds";
        menuCommands[indexCommands++] = "Add a book";
        menuCommands[indexCommands++] = "Add a cd";
        menuCommands[indexCommands++] = "Mark book or cd as loaned";
        menuCommands[indexCommands++] = "Mark book or cd as returned";

        indexCommands = 1;

        for (String command : menuCommands) {
            outPut += "\t" + indexCommands++ + ") ";
            outPut += command;
            outPut += "\n";
        }

        logger.log(Level.INFO, outPut);

    }

}
