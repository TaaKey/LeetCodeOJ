package MedianOfTwoSortedArrays;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by whong53 on 1/23/17.
 */

public class Solution {
    /*
    if (aMid < bMid) Keep [aRight + bLeft]
    else Keep [bRight + aLeft]
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int left = (l1 + l2 + 1) / 2;
        int right = (l1 + l2 + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, left) + getKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 > nums1.length - 1) {
            return nums2[start2 + k - 1];
        }
        if (start2 > nums2.length - 1) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) {
            mid1 = nums1[start1 + k / 2 - 1];
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            mid2 = nums2[start2 + k / 2 - 1];
        }
        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}

class TimeLimitExceeded2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums = new int[l1 + l2];
        int i = 0, j = 0, k = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < l1) {
            nums[k++] = nums1[i++];
        }
        while (j < l2) {
            nums[k++] = nums2[j++];
        }
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            return (double) (nums[nums.length / 2]);
        }
    }
}

class TimeLimitExceeded {

    public static PriorityQueue<Integer> minHeap;
    public static PriorityQueue<Integer> maxHeap;

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums1) {
            addNum(num);
        }
        for (int num : nums2) {
            addNum(num);
        }
        return getMedian();
    }

    private static void addNum(int num) {
        if (num <= getMedian()) {
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

    private static double getMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0.0;
        } else if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
}
