package ai181.kozyrevych;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearch {

    @DisplayName("Binary search")
    @RepeatedTest(value = 100)
    public void bs() {
        int[] nums = new Random().ints(1000, 0, 1000).toArray();
        QuickSort.sort(nums);
        assertEquals(Arrays.binarySearch(nums, 100), BinarySearch.binarySearch(nums, 100));
    }
}
