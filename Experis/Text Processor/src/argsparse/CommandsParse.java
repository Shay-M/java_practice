package argsparse;

import actionprocessor.ProcessorAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandsParse { // implements parseArgs

    private HashMap<String, ProcessorAction> m_commandsAction;

    public CommandsParse(final HashMap<String, ProcessorAction> commandsAction) {
        m_commandsAction = commandsAction;
    }

    //@Override
    public List<ProcessorAction> parse(final String[] args) {
        final List<String> untrsArrayArgsList = Arrays.stream(args).toList();

        final List<ProcessorAction> commandsFromArgs = new ArrayList<>();

        for (String arg : untrsArrayArgsList) {
            if (m_commandsAction.containsKey(arg)) {
                commandsFromArgs.add(m_commandsAction.get(arg));
            }
            else {
                break;
            }
        }
        return commandsFromArgs;
    }
}
