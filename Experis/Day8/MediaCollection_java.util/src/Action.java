import Collection.Collection;

import java.util.logging.Logger;

/*public interface Action {
    void doAction();

    String getName();
}*/
public abstract class Action implements IAction {

    private String m_actionName;
    protected final Collection<OutputableMedia> m_collection;

    protected static final Logger logger = Logger.getLogger(Action.class.getCanonicalName());

    protected Action(Collection<OutputableMedia> mCollection, String actionName) {
        m_collection = mCollection;
        m_actionName = actionName;
    }

    public String getName() {
        return m_actionName;
    }

}


