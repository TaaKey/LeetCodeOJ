package FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Wentao on 1/29/2017.
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        PriorityQueue<Sum> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Sum sum = new Sum(nums1[i], nums2[j]);
                queue.add(sum);
            }
        }
        int size = queue.size();
        for (int i = 0; i < Math.min(size, k); i++) {
            Sum tmp = queue.poll();
            int[] element = new int[]{tmp.num1, tmp.num2};
            result.add(element);
        }
        return result;
    }

    class Sum implements Comparable<Sum> {
        int num1;
        int num2;

        public Sum(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public int compareTo(Sum o) {
            return this.num1 + this.num2 - o.num1 - o.num2;
        }
    }
}
