package KthSmallestElementInASortedMatrix;

import java.util.PriorityQueue;

/**
 * Created by Wentao on 1/29/2017.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // matrix is n * n;
        int n = matrix.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple tmp = queue.poll();
            if (tmp.row == n - 1) {
                continue;
            }
            queue.add(new Tuple(tmp.row + 1, tmp.col, matrix[tmp.row + 1][tmp.col]));
        }
        return queue.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int row;
        int col;
        int val;

        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}

class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        // matrix is n * n;
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = n - 1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
