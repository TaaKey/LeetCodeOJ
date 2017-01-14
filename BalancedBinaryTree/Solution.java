package BalancedBinaryTree;

import Util.TreeNode;

/**
 * Created by whong53 on 1/12/17.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) != -1;
    }

    /**
     * return height of node, -1 if find it unbalanced.
     * @param node
     * @return
     */
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
