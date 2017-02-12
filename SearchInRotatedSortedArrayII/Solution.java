package SearchInRotatedSortedArrayII;

/**
 * Created by Wentao on 2/12/2017.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[lo] < nums[mid] || nums[mid] > nums[hi]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[lo] > nums[mid] || nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                hi--;
            }
        }
        return false;
    }
}
