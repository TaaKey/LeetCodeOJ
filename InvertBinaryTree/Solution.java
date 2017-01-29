package InvertBinaryTree;

import Util.TreeNode;

/**
 * Created by Wentao on 1/29/2017.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode tmp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = tmp;
        return root;
    }
}
