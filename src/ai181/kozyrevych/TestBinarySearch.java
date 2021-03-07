package ai181.kozyrevych;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBinarySearch {
    @DisplayName("Testing Quick sort")
    @RepeatedTest(value = 100)
    public void testSort() {
        int[] nums = new Random().ints(10000, 0, 10000).toArray();
        int[] nums_copy = Arrays.copyOf(nums, nums.length);

        Arrays.parallelSort(nums_copy);
        assertFalse(Arrays.equals(nums_copy, nums));

        QuickSort.sort(nums);
        assertTrue(Arrays.equals(nums_copy, nums));
    }}
