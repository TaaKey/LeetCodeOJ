package ConstructBinaryTreeFromInorderAndPostorderTraversal;

import Util.TreeNode;

/**
 * Created by Wentao on 2/12/2017.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode helper(int postOrderEnd, int inOrderStart, int inOrderEnd, int[] inorder, int[] postorder) {
        if (postOrderEnd < 0 || inOrderStart > inOrderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postOrderEnd]);
        int inOrderIndex = 0;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (inorder[i] == root.val) {
                inOrderIndex = i;
            }
        }
        root.left = helper(postOrderEnd - (inOrderEnd - inOrderIndex + 1), inOrderStart, inOrderIndex - 1, inorder, postorder);
        root.right = helper(postOrderEnd - 1, inOrderIndex + 1, inOrderEnd, inorder, postorder);
        return root;
    }
}
