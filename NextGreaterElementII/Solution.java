package NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Wentao on 2/18/2017.
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return result;
    }
}
