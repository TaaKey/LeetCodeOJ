package LongestAbsoluteFilePath;

/**
 * Created by Wentao on 1/15/2017.
 */
public class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String path : paths) {
            int level = path.lastIndexOf("\t") + 1;
            int currLen = stack[level] + path.length() - level + 1;
            stack[level + 1] = currLen;
            if (path.contains(".")) {
                maxLen = Math.max(maxLen, currLen - 1);
            }
        }
        return maxLen;
    }
}
