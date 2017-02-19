package BinaryTreeZigzagLevelOrderTraversal;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Wentao on 2/18/2017.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        List<Integer> curr = result.get(level);
        if (level % 2 == 0) {
            curr.add(node.val);
        } else {
            curr.add(0, node.val);
        }
        helper(node.left, result, level + 1);
        helper(node.right, result, level + 1);
    }
}

class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (order) {
                    tmp.add(curr.val);
                } else {
                    tmp.add(0, curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(tmp);
            size = queue.size();
            order = order ? false : true;
        }
        return result;
    }
}
