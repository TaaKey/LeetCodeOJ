package PathSumIII;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Wentao on 1/29/2017.
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0)
                + pathSumFrom(root.left, sum - root.val)
                + pathSumFrom(root.right, sum - root.val);
    }
}

class Solution2 {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        int result = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        result += helper(root.left, currSum, target, map) + helper(root.right, currSum, target, map);
        map.put(currSum, map.get(currSum) - 1);
        return result;
    }
}