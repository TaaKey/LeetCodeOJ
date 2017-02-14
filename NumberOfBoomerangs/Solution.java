package NumberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wentao on 2/13/2017.
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int dist = getDist(points[i], points[j]);
                if (!map.containsKey(dist)) {
                    map.put(dist, 0);
                }
                map.put(dist, map.get(dist) + 1);
            }
            for (int val : map.values()) {
                result += val * (val - 1);
            }
            map.clear();
        }
        return result;
    }

    private int getDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
