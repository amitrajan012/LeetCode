package easy;

public class BestTimeToBuyAndSellStockTwo {
	public int maxProfit(int[] prices){
		//Consider peak and valley
		//Refer https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
		int max_profit = 0;
		for(int i=1;i<prices.length;i++){
			if(prices[i] > prices[i-1]){
				max_profit += prices[i]-prices[i-1];
			}
		}
		return max_profit;
	}
}
