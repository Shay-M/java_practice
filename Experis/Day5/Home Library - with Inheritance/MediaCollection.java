import java.util.logging.Level;
import java.util.logging.Logger;

public final class MediaCollection{

    // private static MediaCollection single_instance = null;
    private static final Logger logger = Logger.getLogger(MediaCollection.class.getCanonicalName());
    private IRentable[] _itemsArr = new IRentable[0];

   /*  public static MediaCollection getInstance()
    {
        if (single_instance == null)
            single_instance = new MediaCollection();
        return single_instance;
    } */

    public final void printAll(){

        String outPut = "\n\n";
		int indexCommands = 0;
		
        for (IRentable item : _itemsArr) {
			if (item != null) {
				outPut += "\t[" + (item.getLoaned() ? '*' : ' ');
				outPut += "] " + ++indexCommands + ") ";
            	outPut += "" + item + "";
            	outPut += "\n";
			}
        }

        if (indexCommands==0) {
            outPut += "-There is no media in the library-\n";
        }

        logger.log(Level.INFO, outPut);
    }

    public final void add(final IRentable newItem){
        int oldLength = _itemsArr.length;
        newItem.setId(oldLength);
        final IRentable[] newItemsArr = new IRentable[oldLength + 1]; 
        System.arraycopy(_itemsArr, 0, newItemsArr, 0, oldLength);
        newItemsArr[oldLength] = newItem;
        _itemsArr = newItemsArr; 
    }

    public final void PrintDetail() {
		logger.log(Level.INFO, "\n\n\tItem Details: " + getItemByUser().getDetails() + "\n");		
    }
    
    /* public final IRentable getItemByid(int id) {
	
	
    } */

    // public final int getItemsMenu() {
    public final IRentable getItemByUser() {

        int itemsArraylength = _itemsArr.length;

         if (itemsArraylength == 0) {
            return null;
        }

        logger.log(Level.INFO, "\nType the beginning of the book/cd name:");
        String prefix = System.console().readLine().toLowerCase();

        if (prefix.equals("")) {
            return null;
        }

        String outPut = "\n\n";
            
        int index = 0;
        int command = 0;
        
        int[] itemsIds = new int[itemsArraylength];
        
        for (IRentable item : _itemsArr) {
            if (item != null && item.toString().toLowerCase().startsWith(prefix)) {
                itemsIds[index++] = item.getId();
                outPut += "\t" + index + ") ";
                outPut += "" + item + "";
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

       	logger.log(Level.INFO, outPut + "id: " + command);
		return _itemsArr[itemsIds[command - 1]];
    }


}

