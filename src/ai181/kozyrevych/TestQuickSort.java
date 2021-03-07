package ai181.kozyrevych;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuickSort {

    @DisplayName("Testing Quick sort")
    @RepeatedTest(value = 100)
    public void testSort() {
        int[] nums = new Random().ints(10000, 0, 10000).toArray();
        int[] nums_copy = Arrays.copyOf(nums, nums.length);

        Arrays.parallelSort(nums_copy);
        assertFalse(Arrays.equals(nums_copy, nums));

        QuickSort.sort(nums);
        assertTrue(Arrays.equals(nums_copy, nums));
    }

    @DisplayName("Binary search")
    @RepeatedTest(value = 100)
    public void bs() {
        int[] nums = new Random().ints(1000, 0, 1000).toArray();
        QuickSort.sort(nums);
        assertEquals(Arrays.binarySearch(nums, 100), BinarySearch.binarySearch(nums, 100));
    }


}
