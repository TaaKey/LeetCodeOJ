package GasStation;

/**
 * Created by Wentao on 1/26/2017.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                total = total + tank;
                tank = 0;
            }
        }
        return total + tank < 0 ? -1 : start;
    }
}
