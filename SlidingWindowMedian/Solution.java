package SlidingWindowMedian;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n < 0) {
            return new double[0];
        }
        double[] result = new double[n];
        for (int i = 0; i < nums.length + 1; i++) {
            if (i >= k) {
                result[i - k] = getCurrentMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length)
                add(nums[i]);
        }

        return result;
    }

    private double getCurrentMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0.0;
        }
        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0;
        }
        return (double) maxHeap.peek();
    }

    private void add(int num) {
        if (num <= getCurrentMedian()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    private void remove(int num) {
        if (num <= getCurrentMedian()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }
}
