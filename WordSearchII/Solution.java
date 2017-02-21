package WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Wentao on 2/20/2017.
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    private boolean exist(char[][] board, String word) {
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

class Solution2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, node, result);
        }
        if (j > 0) {
            dfs(board, i, j - 1, node, result);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, node, result);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, node, result);
        }
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode point = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (point.children[i] == null) {
                    point.children[i] = new TrieNode();
                }
                point = point.children[i];
            }
            point.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
