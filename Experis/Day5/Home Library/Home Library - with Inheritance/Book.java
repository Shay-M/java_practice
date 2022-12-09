import java.util.logging.Level;
import java.util.logging.Logger;

public final class Book extends Media implements IRentable {

    private final String _author;
	
    public Book(String title, String author, int id) {
        _title = title;
        _author = author;
		_id = id;
		
        _loaned = false;
    }

    public String getAuthor() {
        return " " + _author + " ";
    }
	
	public String getDetails() {
			
  	return "[" + (_loaned ? '*' : ' ' ) +  "]" + " Title: " + _title + " | " + " Author: " + _author  ;
	
 	} 
}
