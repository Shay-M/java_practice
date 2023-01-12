package actionprocessor;


import bundle.in.InputBundle;
import bundle.out.OutputBundle;

public interface ProcessorAction {
    void doAction(final InputBundle inputBundle, final OutputBundle outputBundle);
}
