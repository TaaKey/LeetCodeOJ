package GameOfLife;

/**
 * Created by Wentao on 2/10/2017.
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dirs = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int[] dir : dirs) {
                    if (i + dir[0] < 0 || i + dir[0] >= board.length || j + dir[1] < 0 || j + dir[1] >= board[0].length) {
                        continue;
                    }
                    if (board[i + dir[0]][j + dir[1]] == 1 || board[i + dir[0]][j + dir[1]] == 2) {
                        live++;
                    }
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
