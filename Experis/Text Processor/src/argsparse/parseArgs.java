package argsparse;

import actionprocessor.ProcessorAction;

import java.util.List;

public interface parseArgs {

    List<ProcessorAction> parse(final String[] args);

}
