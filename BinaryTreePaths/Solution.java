package BinaryTreePaths;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao on 1/15/2017.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if (root.left != null) {
            dfs(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            dfs(root.right, path + root.val + "->", result);
        }
    }
}
