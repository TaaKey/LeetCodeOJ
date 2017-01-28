package BinaryTreeLevelOrderTraversalII;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by whong53 on 1/27/17.
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                level.add(queue.poll().val);
            }
            result.add(0, level);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (level >= result.size()) {
            result.add(0, new ArrayList<>());
        }
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
        result.get(result.size() - level - 1).add(root.val);
    }
}
