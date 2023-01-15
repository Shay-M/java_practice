import actionprocessor.ProcessorAction;
import actionprocessor.Upper;
import argsparse.CommandsParse;
import bundle.in.FileBundleIn;
import bundle.in.InputBundle;
import bundle.in.UserBundleIn;
import bundle.out.FileBundleOut;
import bundle.out.OutputBundle;
import bundle.out.UserBundleOut;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

//

public final class TextProcessor {
    private static final Logger m_logger = Logger.getLogger(TextProcessor.class.getCanonicalName());

    private static final HashMap<String, ProcessorAction> COMMANDS_ACTION = new HashMap<String, ProcessorAction>();
    private static final HashMap<String, OutputBundle> OUTPUT_METHOD = new HashMap<String, OutputBundle>();
    public static final String STDIN = "STDIN";
    public static final String SERVER = "server";

    static {
        COMMANDS_ACTION.put("upper", new Upper(m_logger));
    }

    public final static void main(final String[] args) {
        final TextProcessor textProcessor = new TextProcessor();
        final String[] untrust_args = args;

        if (untrust_args.length < 1) {
            throw new IllegalArgumentException();
        }
        textProcessor.startProcessing(args);

    }

    private void startProcessing(final String[] args) {
        final CommandsParse commandsParse = new CommandsParse(COMMANDS_ACTION);
        final List<ProcessorAction> commandsFromArgs = commandsParse.parse(args);
        assert commandsFromArgs.size() > 1;
        // final int numberOfCommands = commandsFromArgs.size();
        // if (numberOfArgs - numberOfCommands )

        // in put
        final int numberOfCommands = commandsFromArgs.size();
        final InputBundle inputBundle = CreateBundleIn(args, numberOfCommands);
        final OutputBundle outputBundle = CreateBundleOut(args, numberOfCommands + 1);

        for (ProcessorAction commandName : commandsFromArgs) {
            commandName.doAction(inputBundle, outputBundle);
        }

        // final List<String> commandsFromArgs = commandsParse.parse(args);
        // final List<String> commands = new ArrayList<>();
        // commands.add("upper");

    }

    private InputBundle CreateBundleIn(final String[] args, final int numberOfCommands) {
        Optional<String> inPutArg = Optional.ofNullable(args[numberOfCommands]);
        if (inPutArg.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (inPutArg.get().equals(STDIN)) {
            return new UserBundleIn();

        }
        //else {
        final Path inputFile = Paths.get(inPutArg.get()); // arg -> file input name
        return new FileBundleIn(inputFile);
        // }
    }

    private OutputBundle CreateBundleOut(final String[] args, final int numberOfCommands) {
        // Optional<String> outputArg = Optional.ofNullable(args[numberOfCommands]);
        if (numberOfCommands == args.length) {
            return new UserBundleOut(); // work with user
        }
        else {
            // work with files
            Optional<String> outputArg = Optional.ofNullable(args[numberOfCommands]);
            final Path outputFile = Paths.get(outputArg.get()); // arg -> file output name
            return new FileBundleOut(outputFile);
        }
    }
}