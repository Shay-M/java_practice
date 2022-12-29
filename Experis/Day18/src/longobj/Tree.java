package longobj;

import java.util.Optional;
import java.util.logging.Logger;

public class Tree {
    private static final Logger logger = Logger.getLogger(Tree.class.getCanonicalName());
    Optional<Node> m_root = Optional.empty();

    public final void add(final Long date) {

        if (m_root.isEmpty()) {
            m_root = Optional.of(new Node(date));
        } else {
            m_root.get().add(date);
        }
    }

    public final boolean contains(final Long dateToFind) {
        return m_root.isEmpty() ? false : m_root.get().contains(dateToFind);
    }

    public static void main(final String[] args) {

        final Tree longTree = new Tree();
        longTree.add(5L);
        longTree.add(3L);
        longTree.add(7L);
        longTree.add(2L);
        longTree.add(2L);


    }
}


