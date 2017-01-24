package SimplifyPath;

import java.util.*;

/**
 * Created by Wentao on 1/23/2017.
 */
public class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        Set<String> ignore = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !deque.isEmpty()) {
                deque.pop();
            } else if (!ignore.contains(dir)) {
                deque.push(dir);
            }
        }
        String result = "";
        for (String dir : deque) {
            result = "/" + dir + result;
        }
        return result.isEmpty() ? "/" : result;
    }
}
