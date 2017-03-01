package ValidNumber;

/**
 * Created by whong53 on 3/1/17.
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        boolean hasPoint = false, hasE = false, hasNumber = false, hasNumberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                hasNumber = true;
                hasNumberAfterE = true;
                continue;
            } else if (s.charAt(i) == '.') {
                if (hasE || hasPoint) {
                    return false;
                }
                hasPoint = true;
            } else if (s.charAt(i) == 'e') {
                if (hasE || !hasNumber) {
                    return false;
                }
                hasE = true;
                hasNumberAfterE = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return hasNumber && hasNumberAfterE;
    }
}
