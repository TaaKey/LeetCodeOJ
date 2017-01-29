package QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Wentao on 1/28/2017.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        List<int[]> result = new ArrayList<int[]>();
        for (int[] cur : people) {
            result.add(cur[1], cur);
        }
        return result.toArray(new int[people.length][]);
    }
}
