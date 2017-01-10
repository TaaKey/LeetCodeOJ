package TrappingRainWaterII;

import java.util.PriorityQueue;

/**
 * Created by whong53 on 1/10/17.
 */
public class Solution {
    private class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        public int compareTo(Cell o) {
            // order by height asc
            return this.height - o.height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int result = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] direction : directions) {
                int row = cell.row + direction[0];
                int col = cell.col + direction[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    result += Math.max(0, cell.height - heightMap[row][col]);
                    // when adding a new cell to the queue, need to over write the height,
                    // cos height lower the current height should not be considered as boarder.
                    queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
                }
            }
        }
        return result;
    }
}
