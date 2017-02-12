package ConstructBinaryTreeFromPreorderAndInorderTraversal;

import Util.TreeNode;

/**
 * Created by Wentao on 2/12/2017.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preOrderStart, int inOrderStart, int inOrderEnd, int[] preorder, int[] inorder) {
        if (preOrderStart >= preorder.length || inOrderStart > inOrderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrderStart]);
        int inOrderIndex = 0;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (inorder[i] == root.val) {
                inOrderIndex = i;
            }
        }
        root.left = helper(preOrderStart + 1, inOrderStart, inOrderIndex - 1, preorder, inorder);
        root.right = helper(preOrderStart + inOrderIndex - inOrderStart + 1, inOrderIndex + 1, inOrderEnd, preorder, inorder);
        return root;
    }
}
