package PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao on 2/4/2017.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> factorials = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        int factorial = 1;
        factorials.add(factorial);
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            factorials.add(factorial);
        }
        k = k - 1;
        for (int i = 1; i <= n; i++) {
            int index = k / factorials.get(n - i);
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k = k - index * factorials.get(n - i);
        }
        return sb.toString();
    }
}
