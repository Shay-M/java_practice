import java.util.logging.Level;
import java.util.logging.Logger;

public final class Book implements IRentable {

	private final int _id;
    private final String _title;
    private final String _author;
	
    private boolean _loaned;

    public Book(String title, String author, int id) {
        _title = title;
        _author = author;
		_id = id;
		
        _loaned = false;
    }


//    public String getTitle() {
//        return " " + _title + " ";
//    }

	public int getId() {
		return _id;
	}

    public String getAuthor() {
        return " " + _author + " ";
    }

    public boolean getLoaned() {
        return _loaned;
    }
	
	public void setLoaned(boolean loaned) {
		_loaned = loaned;
	}
	
	public String toString() { //overriding the toString() method  
  		return "" + _title + " ";
 	}  
	
	public String getDetails() {
	
	char loanedChar = _loaned ? '*' : ' ';
		
  	return "[" + loanedChar +  "]" + " Title: " + _title + " | " + " Author: " + _author  ;
	
 	} 
}
