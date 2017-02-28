package MinimumAbsoluteDifferenceInBST;

import Util.TreeNode;

import java.util.TreeSet;

/**
 * Created by whong53 on 2/28/17.
 */

// In-Order traverse, time complexity O(N), space complexity O(1).
public class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}

// What if it is not a BST? (Follow up of the problem)
// The idea is to put values in a TreeSet and then every time we can use O(lgN) time to lookup for the nearest values.
// Pre-Order traverse, time complexity O(NlgN), space complexity O(N).
class Solution2 {
    int min = Integer.MAX_VALUE;
    TreeSet<Integer> set = new TreeSet<>();

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, Math.abs(root.val - set.floor(root.val)));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, Math.abs(root.val - set.ceiling(root.val)));
            }
        }
        set.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        return min;
    }
}
