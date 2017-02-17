package NumberOfSegmentsInAString;

/**
 * Created by whong53 on 2/16/17.
 */
public class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        } else {
            return s.trim().split("\\s+").length;
        }
    }
}
