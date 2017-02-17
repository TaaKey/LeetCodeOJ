package RangeSumQueryImmutable;

/**
 * Created by whong53 on 2/16/17.
 */
public class NumArray {

    private int[] sumRange;

    public NumArray(int[] nums) {
        if (nums != null && nums.length > 0) {
            sumRange = new int[nums.length + 1];
        }
        int sum = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            sum += nums[i - 1];
            sumRange[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange[j + 1] - sumRange[i];
    }
}
