package FirstBadVersion;

/**
 * Created by Wentao on 1/22/2017.
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}
