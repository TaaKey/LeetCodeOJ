package NumberComplement;

/**
 * Created by whong53 on 1/25/17.
 */
public class Solution {
    public int findComplement(int num) {
        int mask = (num << 1) - 1;
        num = ~num;
        return num & mask;
    }
}
