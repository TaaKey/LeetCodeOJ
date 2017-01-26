package ConvertANumberToHexadecimal;

/**
 * Created by whong53 on 1/25/17.
 */
public class Solution {
    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        String result = "";
        while (num != 0) {
            result = map[num & 15] + result;
            num >>>= 4;
        }
        return result;
    }
}
