package UglyNumber;

/**
 * Created by whong53 on 3/2/17.
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        } else if (num == 1 || num == 2 || num == 3 || num == 5) {
            return true;
        } else if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        } else {
            return false;
        }
    }
}

class Solution2 {
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
