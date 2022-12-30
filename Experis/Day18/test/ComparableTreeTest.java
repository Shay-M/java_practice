import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class ComparableTreeTest {


    @Test
    void notInitialized() {
        final ComparableTree<Integer> tree;
    }

    @Test
    void emptyTree() {
        final ComparableTree<Long> tree = new ComparableTree<Long>();
        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    void notEmptyTree() {
        final ComparableTree<Long> tree = new ComparableTree<Long>();
        tree.add(5L);
        Assertions.assertFalse(tree.isEmpty());
    }

    @Test
    void sizeOfTree() {
        final ComparableTree<String> tree = new ComparableTree<String>();
        Assertions.assertEquals(0, tree.size());
        tree.add("5L");
        Assertions.assertEquals(1, tree.size());
        tree.add("5L");
        Assertions.assertEquals(2, tree.size());
        tree.add("3L");
        Assertions.assertEquals(3, tree.size());
        tree.remove("5L");
        Assertions.assertEquals(2, tree.size());
        tree.remove("1L");
        Assertions.assertEquals(2, tree.size());
    }

    @Test
    void addNodeAndTestIfHeContain() {
        final ComparableTree<Long> tree = new ComparableTree<Long>();
        tree.add(5L);
        tree.add(3L);
        Assertions.assertTrue(tree.contains(5L));
    }

    @Test
    void addDifferentNodeAndTestIfHeContain() {
        final ComparableTree<Long> tree = new ComparableTree<Long>();
        tree.add(1L);
        tree.add(3L);
        Assertions.assertFalse(tree.contains(5L));
    }

    @Test
    void addNodeAndGetHim() {
        final ComparableTree<Long> tree = new ComparableTree<Long>();
        tree.add(1L);
        Assertions.assertEquals(1L, tree.get(1L));

        tree.add(5L);
        tree.add(2L);
        Assertions.assertEquals(2L, tree.get(2L));
    }

    @Test
    void addNodeAndGetNotHim() {
        final ComparableTree<Long> tree = new ComparableTree<Long>();
        tree.add(1L);
        tree.add(3L);
        tree.add(5L);
        Assertions.assertNull(tree.get(8L));
    }

    @Test
    void addLocalTimeNodeAndGetHim() {
        final ComparableTree<LocalTime> tree = new ComparableTree<LocalTime>();
        tree.add(LocalTime.now());
        tree.add(LocalTime.of(6, 8, 5));
        Assertions.assertTrue(tree.contains(LocalTime.of(6, 8, 5)));
    }

    @Test
    void addNodeAndRemoveHimAndGetHim() {
        final ComparableTree<Long> tree = new ComparableTree<Long>();
        tree.add(1L);
        tree.add(3L);
        tree.remove(1L);
        Assertions.assertNull(tree.get(1L));
    }
}