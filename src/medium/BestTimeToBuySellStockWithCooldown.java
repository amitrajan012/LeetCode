package medium;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class BestTimeToBuySellStockWithCooldown {
    public int maxProfit(int[] prices) {
        //Base case
    		if(prices.length <= 1) return 0;
    		int[] S0 = new int[prices.length];
    		int[] S1 = new int[prices.length];
    		int[] S2 = new int[prices.length];
    		S1[0] = -prices[0]; S2[0] = Integer.MIN_VALUE;
    		
    		for(int i=1;i<prices.length;i++) {
    			S0[i] = Integer.max(S0[i-1], S2[i-1]);
    			S1[i] = Integer.max(S1[i-1], S0[i-1]-prices[i]);
    			S2[i] = S1[i-1] + prices[i];
    		}
    		
    		return Integer.max(S0[prices.length-1], S2[prices.length-1]);
    }
}
