package MinimumMovesToEqualArrayElementsII;

/**
 * Created by whong53 on 2/6/17.
 */
public class Solution {
    public int minMoves2(int[] nums) {
        int result = 0;
        int median = findMedian(nums);
        for (int num : nums) {
            result += Math.abs(median - num);
        }
        return result;
    }

    private int findMedian(int[] nums) {
        return getKth(nums.length / 2 + 1, nums, 0, nums.length - 1);
    }

    private int getKth(int k, int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        while (true) {
            while (nums[left] < pivot && left < right) {
                left++;
            }
            while (nums[right] >= pivot && right > left) {
                right--;
            }
            if (left == right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, left, end);
        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
