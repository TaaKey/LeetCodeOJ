package SumOfLeftLeaves;

import Util.TreeNode;

import java.util.Stack;

/**
 * Created by whong53 on 1/12/17.
 */
public class SolutionIterative {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    result += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return result;
    }
}
