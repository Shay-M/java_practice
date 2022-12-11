
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HomeLibrary {
    private static final Logger logger = Logger.getLogger(HomeLibrary.class.getCanonicalName());

    private static final int NUM_COMMANDS = 6;
	
	private static final String YES = "y";

	private static final MediaCollection mediaCollection = new MediaCollection();// = MediaCollection.getInstance();
	private static final MenuManager menuManager = new MenuManager();

    public static void main(final String[] args) {
		
		// mediaCollection = new MediaCollection(); //?
				
		mediaCollection.add(new Book ("bookTitle" , "bookAuthor"));
		mediaCollection.add(new Cd ("cdTitle" , false , "bandOrSinger"));
		
		while(true){
			
	        printMenu();
			
	        try {
	           final int command = Integer.valueOf(System.console().readLine());
			   
			   switch (command) {
	            case 1:
	                mediaCollection.printAll();
	                break;
	            case 2:
	                mediaCollection.PrintDetail();
	                break;
	            case 3:
	                AddBook();
	                break;
	            case 4:
	                AddCD();
	                break;
	            case 5:
	                MarkBookOrCdAsLoaned();
	                break;
	            case 6:
	                MarkBookOrCdAsReturned();
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


	private static final void AddBook() {
		
		logger.log(Level.INFO, "\nWhat is the book title?");
		String bookTitle = System.console().readLine();
		
		logger.log(Level.INFO, "Who is the author?");
		String bookAuthor = System.console().readLine();
		
		try {
		mediaCollection.add(new Book (bookTitle , bookAuthor));
		} catch (NullPointerException ex) {
			logger.log(Level.INFO, "\n" + ex.getMessage() + "\n");
			return;
		}
		
		logger.log(Level.INFO, "\tBook: " + bookTitle + " Added !\n");

	}
	
	private static final void AddCD() {
	
		logger.log(Level.INFO, "\nWhat is the cd title?");
		String cdTitle = System.console().readLine();
		
		logger.log(Level.INFO, "Is this an original cd? (y/n)");
		
		boolean cdOriginal = System.console().readLine().equals(YES) ? true : false; //todo
		
		logger.log(Level.INFO, "Who is the band/singer?");
		String bandOrSinger = System.console().readLine();
		
		try {
			mediaCollection.add(new Cd (cdTitle , cdOriginal , bandOrSinger));
		} catch (NullPointerException ex) {
			logger.log(Level.INFO, "\n" + ex.getMessage() + "\n");
			return;
		}

		logger.log(Level.INFO, "\tCd: " + cdTitle + " Added !\n");
	}
	
	private static final void MarkBookOrCdAsLoaned() {
		
		mediaCollection.getItemByUser().setLoaned(true);
		
		logger.log(Level.INFO, "\n\tBook is loaned! ");	
	}
	
	private static final void MarkBookOrCdAsReturned() {
		mediaCollection.getItemByUser().setLoaned(false);
		
		logger.log(Level.INFO, "\n\tBook is return! ");	
	}

    private static final void printMenu() {

        String[] menuCommands = new String[NUM_COMMANDS];
        String outPut = "\nChoose one of the options (1-"+ NUM_COMMANDS +"), any other key to exit.\n";

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
