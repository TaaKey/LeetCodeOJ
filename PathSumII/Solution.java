package PathSumII;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao on 1/29/2017.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(root, result, curr, sum);
        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, List<Integer> curr, int sum) {
        if (root == null) {
            return;
        }
        curr.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
            return;
        } else {
            helper(root.left, result, curr, sum - root.val);
            helper(root.right, result, curr, sum - root.val);
        }
        curr.remove(curr.size() - 1);
    }
}
