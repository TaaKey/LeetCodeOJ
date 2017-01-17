package SlidingWindowMaximum;

import java.util.*;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length - k + 1;
        if (n < 0) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(num, max);
            }
            return new int[]{max};
        }
        int[] result = new int[n];
        int j = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[j] = nums[deque.peek()];
                j++;
            }
        }
        return result;
    }
}
