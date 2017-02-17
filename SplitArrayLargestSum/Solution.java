package SplitArrayLargestSum;

/**
 * Created by whong53 on 2/16/17.
 */

public class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (m == 1) {
            return sum;
        }
        int l = max, r = sum;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean valid(int target, int[] nums, int m) {
        int count = 1;
        int tmp = 0;
        for (int num : nums) {
            tmp += num;
            if (tmp > target) {
                tmp = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
