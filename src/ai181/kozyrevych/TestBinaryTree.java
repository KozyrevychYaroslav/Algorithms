package ai181.kozyrevych;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestBinaryTree {

    @Test
    @DisplayName("Testing add + search method in Tree")
    public void search() {
        Tree<Integer> tree = new Tree<>();
        tree.add(9);
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
        Tree<Integer> tree = new Tree<>();
        tree.add(9);
        tree.add(6);
        tree.add(12);
        tree.add(7);
        tree.add(11);
        tree.add(1, 10, 14, 4, 3, 18);
        assertEquals("[9, 6, 12, 1, 7, 11, 14, 4, 10, 18, 3]", tree.traversal().toString());
        System.out.println(tree);
    }

    @DisplayName("Testing node deletion")
    @RepeatedTest(value = 100)
    public void delete() {
        Tree<Integer> tree = new Tree<>();
        Integer[] nums = new Random().ints(100, 0, 1000).boxed().toArray(Integer[]::new);
        Random generator = new Random();
        int randomIndex = generator.nextInt(nums.length);

        tree.add(nums);
        List<Integer> list = new ArrayList<>(tree.traversal());

        tree.remove(nums[randomIndex]);
        list.remove(nums[randomIndex]);

        list.sort(Comparator.naturalOrder());
        List<Integer> mainList = tree.traversal();
        mainList.sort(Comparator.naturalOrder());

        assertEquals(list.toString(), mainList.toString());
    }

    @DisplayName("Testing node location after deletion")
    @Test
    public void location() {
        Tree<Integer> tree = new Tree<>();
        tree.add(9);
        tree.add(6);
        tree.add(12);
        tree.add(7);
        tree.add(11);
        tree.add(1, 10, 6, 14, 4, 3, 18);

        System.out.println("Изначальное дерево");
        System.out.println(tree);
        tree.remove(9);// удаление корня дерева (на месте корня должен стоять крайний левый узел правого узла корня)
        assertEquals("[10, 6, 12, 1, 7, 11, 14, 4, 18, 3]", tree.traversal().toString());
        System.out.println("После удаления 9");
        System.out.println(tree);
        tree.remove(12);
        System.out.println("После удаления 12");
        System.out.println(tree);
        tree.add(15);

        System.out.println("После добавления 15");
        System.out.println(tree);

        System.out.println("После удаления 18");
        tree.remove(18);
        System.out.println(tree);

    }


}
