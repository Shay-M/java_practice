import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeTest {


    @Test
    void notInitialized() {
        final Tree<Long> tree;
    }

    @Test
    void emptyTree() {
        final Tree<Long> tree = new Tree<Long>();
        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    void notEmptyTree() {
        final Tree<Long> tree = new Tree<Long>();
        tree.add(5L);
        Assertions.assertTrue(!tree.isEmpty());
    }

    @Test
    void sizeOfTree() {
        final Tree<String> tree = new Tree<String>();
        Assertions.assertEquals(0, tree.size());
        tree.add("5L");
        Assertions.assertEquals(1, tree.size());
        tree.add("5L");
        Assertions.assertEquals(2, tree.size());
        tree.add("3L");
        Assertions.assertEquals(3, tree.size());
    }

    @Test
    void addNodeAndTestIfHeContain() {
        final Tree<Long> tree = new Tree<Long>();
        tree.add(5L);
        tree.add(3L);
        Assertions.assertTrue(tree.contains(5L));
    }

    @Test
    void addDifferentNodeAndTestIfHeContain() {
        final Tree<Long> tree = new Tree<Long>();
        tree.add(1L);
        tree.add(3L);
        Assertions.assertTrue(!tree.contains(5L));
    }

    @Test
    void addNodeAndGetHim() {
        final Tree<Long> tree = new Tree<Long>();
        tree.add(1L);
        tree.add(3L);
        tree.add(5L);
        Assertions.assertEquals(3L, tree.get(3L));
    }

    @Test
    void addNodeAndGetNotHim() {
        final Tree<Long> tree = new Tree<Long>();
        tree.add(1L);
        tree.add(3L);
        tree.add(5L);
        Assertions.assertNull(tree.get(8L));
    }

}