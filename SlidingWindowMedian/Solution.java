package SlidingWindowMedian;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] subNums = Arrays.copyOfRange(nums, i, i + k);
            double subMedia = findMedia(subNums);
            result[i] = subMedia;
        }
        return result;
    }

    private double findMedia(int[] nums) {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<Long>(Collections.reverseOrder());
        for (long num : nums) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.poll() + minHeap.poll()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
}
