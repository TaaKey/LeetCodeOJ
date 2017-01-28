package BinaryTreeLevelOrderTraversal;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by whong53 on 1/27/17.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(level);
        }
        return result;
    }
}
