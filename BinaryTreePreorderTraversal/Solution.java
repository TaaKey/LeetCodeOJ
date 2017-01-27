package BinaryTreePreorderTraversal;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by whong53 on 1/25/17.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode treeNode, List<Integer> result) {
        if (treeNode != null) {
            result.add(treeNode.val);
            helper(treeNode.left, result);
            helper(treeNode.right, result);
        }
    }
}

class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> rights = new Stack<>();
        while (root != null) {
            result.add(root.val);
            if (root.right != null) {
                rights.push(root.right);
            }
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pop();
            }
        }
        return result;
    }
}