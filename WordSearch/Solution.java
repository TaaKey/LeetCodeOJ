package WordSearch;

/**
 * Created by Wentao on 2/20/2017.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, letters, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, char[] letters, int start) {
        if (start == letters.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != letters[start]) {
            return false;
        }
        board[i][j] ^= 256;
        boolean exist = exist(board, i, j + 1, letters, start + 1)
                || exist(board, i, j - 1, letters, start + 1)
                || exist(board, i + 1, j, letters, start + 1)
                || exist(board, i - 1, j, letters, start + 1);

        board[i][j] ^= 256;
        return exist;
    }
}
