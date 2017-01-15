package HouseRobberIII;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.left != null) {
            result += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            result += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(result + root.val, rob(root.left) + rob(root.right));
    }
}