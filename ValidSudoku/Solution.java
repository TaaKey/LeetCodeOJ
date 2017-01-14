package ValidSudoku;

import java.util.HashSet;

/**
 * Created by whong53 on 1/13/17.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<Character>();
            HashSet<Character> colSet = new HashSet<Character>();
            HashSet<Character> cubeSet = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
                int cubeRow = 3 * (i / 3);
                int cubeCol = 3 * (i % 3);
                if (board[cubeRow + j / 3][cubeCol + j % 3] != '.' && !cubeSet.add(board[cubeRow + j / 3][cubeCol + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
