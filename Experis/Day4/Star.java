import java.util.logging.Level;
import java.util.logging.Logger;

public final class Star {

	private  int _x;
	private  int _y;
	private char _shapeOfStar;
	
	public Star() {}
	
	public Star(int x , int y , char shapeOfStar) {
		_x = x;
		_y = y;
		_shapeOfStar = shapeOfStar;
	}
	
	public String getShapeOfStar() {
		return " " + _shapeOfStar + " ";
	}
	
}
