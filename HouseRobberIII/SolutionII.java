package HouseRobberIII;

import Util.TreeNode;

import java.util.HashMap;

/**
 * Created by Wentao on 1/14/2017.
 */
public class SolutionII {

    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        return robSub(root, map);
    }

    private int robSub(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        int max = Math.max(root.val + val, rob(root.left) + rob(root.right));
        map.put(root, max);
        return max;
    }
}
