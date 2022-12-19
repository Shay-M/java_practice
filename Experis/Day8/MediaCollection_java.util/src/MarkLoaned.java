import Collection.Collection;

public class MarkLoaned extends Action implements IAction {

    private static final String ACTION_NAME = "Mark book or cd as loaned.";
    protected MarkLoaned(Collection mCollection) {
        super(mCollection, ACTION_NAME);
    }

    @Override
    public void doAction() {

    }
}
