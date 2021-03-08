package ai181.kozyrevych;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBinaryTree {
    @Test
    @DisplayName("Testing add + search method in Tree")
    public void search() {
        Tree<Integer> tree = new Tree<>(9);
        tree.add(6);
        tree.add(12);
        tree.add(7);
        tree.add(11);
        tree.add(1, 10, 6, 14, 4, 3, 18);

        assertTrue(tree.search(1));
        assertTrue(tree.search(3));
        assertTrue(tree.search(4));
        assertTrue(tree.search(6));
        assertTrue(tree.search(7));
        assertTrue(tree.search(9));
        assertTrue(tree.search(10));
        assertTrue(tree.search(11));
        assertTrue(tree.search(12));
        assertTrue(tree.search(14));
        assertTrue(tree.search(18));

        assertFalse(tree.search(20));
        assertFalse(tree.search(2));
        assertFalse(tree.search(8));
    }

    @Test
    @DisplayName("Testing traversal")
    public void traversal() {
        Tree<Integer> tree = new Tree<>(9);
        tree.add(6);
        tree.add(12);
        tree.add(7);
        tree.add(11);
        tree.add(1, 10, 14, 4, 3, 18);
        assertEquals("[9, 6, 12, 1, 7, 11, 14, 4, 10, 18, 3]", tree.traversal().toString());
        System.out.println(tree);
    }
}
