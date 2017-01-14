package IncreasingTripletSubsequence;

/**
 * Created by whong53 on 1/13/17.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= big) {
                big = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
