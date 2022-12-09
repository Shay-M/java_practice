public abstract class Media{
    protected int _id;
    protected String _title;

    protected boolean _loaned;

    public int getId(){
		return _id;
	}

    public boolean getLoaned() {
        return _loaned;
    }

    public void setLoaned(boolean loaned){
		_loaned = loaned;
	}

    public String toString() {		//overriding the toString() method  
        return "" + _title + " ";
 	}  
	
}