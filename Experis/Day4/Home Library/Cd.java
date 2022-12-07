import java.util.logging.Level;
import java.util.logging.Logger;

public final class Cd implements IRentable {

	private final int _id;
    private final String _title;
	private final boolean _isOriginal;
    private final String _bandOrSinger;
	
    private boolean _loaned;

    public Cd (String title, boolean isOriginal , String bandOrSinger, int id) {
	
        _title = title;
		_isOriginal = isOriginal;
        _bandOrSinger = bandOrSinger;
		_id = id;
		
        _loaned = false;
    }
	
	public int getId(){
		return _id;
	}

    public String getBandOrSinger() {
        return " " + _bandOrSinger + " ";
    }

    public boolean getIsOriginal() {
        return _isOriginal;
    }
	
	public String toString() {		//overriding the toString() method  
  		return "" + _title + " ";
 	}  
	
	public boolean getLoaned() {
        return _loaned;
    }
	
	public void setLoaned(boolean loaned){
		_loaned = loaned;
	}
	
	public String getDetails() {
	
	char loanedChar = _loaned ? '*' : ' ';
		
  	return "[" + loanedChar +  "]" + " Title: " + _title + " | " + "BandOrSinger: " + _bandOrSinger + " | " + "Original: " + String.valueOf(_isOriginal) ;
 	} 

}
