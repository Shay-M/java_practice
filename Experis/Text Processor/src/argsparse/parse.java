package argsparse;

import java.util.List;

public interface parse<T> {

    List<T> parseArgs(final String[] args);

}
