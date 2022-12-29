import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LongTree {
    private static final Logger logger = Logger.getLogger(LongTree.class.getCanonicalName());

    Optional<LongNode> m_root = Optional.empty();

    private void add(Long date) {
        final LongNode longNodeToAdd = new LongNode(date);
        Optional<LongNode> pointerX = m_root;
        Optional<LongNode> pointerY = Optional.empty();

        while (pointerX.isPresent()) {
            pointerY = pointerX;
            if (pointerX.get().compareTo(date) > 0) {
                pointerX = pointerX.get().getLeft();
            } else {
                pointerX = pointerX.get().getRight();
            }
        }

        if (pointerY.isEmpty()) {
            pointerY = Optional.of(longNodeToAdd);
        } else if (pointerY.get().compareTo(date) > 0) {
            pointerY.get().setLeft(Optional.ofNullable(longNodeToAdd));
            // pointerY.get().getLeft().get() = longNodeToAdd;
        } else {
            pointerY.get().setRight(Optional.ofNullable(longNodeToAdd));
        }
        m_root = pointerY;
    }

    public static void main(String[] args) {
        final LongTree longTree = new LongTree();
        longTree.add(5L);
        longTree.add(3L);
        longTree.add(7L);
        longTree.add(2L);

        Optional<LongNode> test = longTree.m_root;

    }
}


