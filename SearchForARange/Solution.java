package SearchForARange;

/**
 * Created by whong53 on 2/1/17.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] != target) {
            return result;
        } else {
            result[0] = start;
        }
        end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2 + 1;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        result[1] = end;
        return result;
    }
}
