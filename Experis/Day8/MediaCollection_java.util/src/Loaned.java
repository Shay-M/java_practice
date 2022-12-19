public class Loaned {
    
    final private String loanedName;
    final private Object obj;


    public Loaned(Object obj, String loanedName) {
        this.loanedName = loanedName;
        this.obj = obj;
    }

    public Media getObj() {
        return ((Media) this.obj);
    }

    public String loanedTo() {
        return null;
    }

    public String getName() {
        return loanedName;
    }
}
