import java.util.logging.Logger;

/*public interface Action {
    void doAction();

    String getName();
}*/
public abstract class Action implements IAction {

    private String m_actionName;
    protected final Collection m_collection;

    protected static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    protected Action(Collection mCollection, String actionName) {
        m_collection = mCollection;
        m_actionName = actionName;
    }

    public String getName() {
        return m_actionName;
    }

}


