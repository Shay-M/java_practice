public class MarkReturned extends Action implements IAction {
    private static final String ACTION_NAME = "Mark book or cd as returned.";
    protected MarkReturned(Collection mCollection, String actionName) {
        super(mCollection, actionName);
    }

    @Override
    public void doAction() {

    }
}
