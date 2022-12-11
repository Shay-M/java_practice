import java.util.logging.Level;
import java.util.logging.Logger;

public final class Cd extends Media implements IRentable {

    private final String _bandOrSinger;
	private final boolean _isOriginal;
	

    public Cd (String title, boolean isOriginal , String bandOrSinger) {
	
        _title = title;
		_isOriginal = isOriginal;
        _bandOrSinger = bandOrSinger;
		
        _loaned = false;
    }
	
    public String getBandOrSinger() {
        return " " + _bandOrSinger + " ";
    }

    public boolean getIsOriginal() {
        return _isOriginal;
    }
	
	public String getDetails() {
			
  	return "[" + (_loaned ? '*' : ' ' ) +  "]" + " Title: " + _title + " | " + "BandOrSinger: " + _bandOrSinger + " | " + "Original: " + String.valueOf(_isOriginal) ;
 	} 

}
