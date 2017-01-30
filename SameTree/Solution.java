package SameTree;

import Util.TreeNode;

import java.util.Stack;

/**
 * Created by whong53 on 1/30/17.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        return (p.val == q.val) &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
