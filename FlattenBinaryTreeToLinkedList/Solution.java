package FlattenBinaryTreeToLinkedList;

import Util.TreeNode;

/**
 * Created by whong53 on 1/30/17.
 */
public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        // at this point, prev = root.right;
        // root.right is flattened;
        flatten(root.left);
        // at this point, prev = root.left;
        // root.left is flattened;
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
