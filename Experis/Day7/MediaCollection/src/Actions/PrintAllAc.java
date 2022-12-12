package Actions;


public class PrintAllAc implements Action {
    private final String actionName = "List all books & cds";
    private Iterator m_iterator;

    public PrintAllAc(Iterator iterator) {

        m_iterator = iterator;
    }


    @Override
    public void doAction() {

    }

    @Override
    public String getName() {
        return actionName;
    }


}
