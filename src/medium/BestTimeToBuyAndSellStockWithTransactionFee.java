package medium;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 * Refer: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        //Base cases: T[i][k][0/1] denotes maximum profit gained at the end of (i-1)th day by doing k transactions, the third index denotes the number of stocks in hand
    		// T[-1][k][0] = 0, T[-1][k][1] = -Infinity 
    		// T[i][0][0] = 0, T[i][0][1] = -Infinity
    		// T[i][k][0] = Either rest after T[i-1][k][0] or sell after T[i-1][k][1] (Here number of transaction is not changed as transaction has already started once we bought the stock)
    		// Hence, T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
    		// Similarly, T[i][k][1] = max(Buy: T[i-1][k-1][0] - prices[i], Rest: T[i-1][k][1])
    	
    		//In our case, K is infinity and hence there is no significance of k-1
    		int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE; //Initialization
    		for(int price: prices) {
    			int old = T_ik0;
    			T_ik0 = Math.max(T_ik0, T_ik1 + price); //Rest or Sell
    			T_ik1 = Math.max(T_ik1, old - price -fee); //Rest or buy (fee calculated at the time of buying)
    		}
    		return T_ik0;
    }
}
