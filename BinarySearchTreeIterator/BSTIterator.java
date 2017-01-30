package BinarySearchTreeIterator;

import Util.TreeNode;

import java.util.Stack;

/**
 * Created by whong53 on 1/30/17.
 */
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    private void pushAll(TreeNode root) {
        for (; root != null; root = root.left) {
            stack.push(root);
        }
    }
}
