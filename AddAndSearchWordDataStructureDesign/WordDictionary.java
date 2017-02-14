package AddAndSearchWordDataStructureDesign;

/**
 * Created by Wentao on 2/13/2017.
 */
public class WordDictionary {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
        root.val = ' ';
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode point = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (point.children[c - 'a'] == null) {
                point.children[c - 'a'] = new TrieNode(c);
            }
            point = point.children[c - 'a'];
        }
        point.endOfWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode point = root;
        return searchDfs(word.toCharArray(), 0, point);
    }

    private boolean searchDfs(char[] wordArray, int i, TrieNode root) {
        TrieNode point = root;
        if (i == wordArray.length) {
            return root.endOfWord;
        }
        char c = wordArray[i];
        if (c != '.') {
            return root.children[c - 'a'] != null && searchDfs(wordArray, i + 1, root.children[c - 'a']);
        } else {
            for (int j = 0; j < root.children.length; j++) {
                if (root.children[j] != null && searchDfs(wordArray, i + 1, root.children[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}

class TrieNode {
    public char val;
    public boolean endOfWord;
    // 'a' - 'z'
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {

    }

    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}