package ImplementTrie;

/**
 * Created by whong53 on 1/20/17.
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /** Inserts a word into the trie. */

    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode point = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (point.children[c - 'a'] == null) {
                return false;
            }
            point = point.children[c - 'a'];
        }
        return point.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode point = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (point.children[c - 'a'] == null) {
                return false;
            }
            point = point.children[c - 'a'];
        }
        return true;
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
