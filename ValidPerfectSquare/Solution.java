package ValidPerfectSquare;

/**
 * Created by whong53 on 1/27/17.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        for (int i = 0; i <= num / 2; i++) {
            if (num == i * i) {
                return true;
            }
        }
        return false;
    }
}
