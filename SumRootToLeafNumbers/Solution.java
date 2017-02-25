package SumRootToLeafNumbers;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whong53 on 2/24/17.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    }
}
