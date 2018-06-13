package medium;
/*
 * https://leetcode.com/problems/gas-station/description/
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = -1;
        int lowestSum = Integer.MAX_VALUE;
        
        int accumulatedGas = 0;
        for(int i=0;i<gas.length;i++) {
        		accumulatedGas += (gas[i] - cost[i]);
        		if(accumulatedGas < lowestSum) {
        			lowestSum = accumulatedGas;
        			index = (i + 1) % gas.length;
        		}
        }
		return accumulatedGas >= 0 ? index : -1;
    }
}
