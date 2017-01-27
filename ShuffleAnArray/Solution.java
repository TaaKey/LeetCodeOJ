package ShuffleAnArray;

import java.util.Random;

/**
 * Created by whong53 on 1/25/17.
 */
public class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] clone = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            int j = random.nextInt(i + 1);
            swap(clone, i, j);
        }
        return clone;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
