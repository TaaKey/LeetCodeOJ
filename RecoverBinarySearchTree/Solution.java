package RecoverBinarySearchTree;

import Util.TreeNode;

/**
 * Created by Wentao on 2/12/2017.
 */
public class Solution {

    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (first == null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev.val > root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
