package BinaryTreeRightSideView;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whong53 on 1/12/17.
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode treeNode, List<Integer> result, int level) {
        if (treeNode == null) {
            return;
        }
        if (result.size() == level) {
            result.add(treeNode.val);
        }
        helper(treeNode.right, result, level + 1);
        helper(treeNode.left, result, level + 1);
    }
}
