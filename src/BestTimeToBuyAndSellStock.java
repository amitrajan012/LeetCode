
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        //Base case
		if(prices == null || prices.length == 0 || prices.length == 1){
			return 0;
		}
		//Iterate over the array
		int buying_price = prices[0];
		int profit = 0;
		for(int i=1;i<prices.length;i++){
			if(prices[i] < buying_price){
				buying_price = prices[i];
			}else{
				if(prices[i]-buying_price > profit){
					profit = prices[i]-buying_price;
				}
			}
		}
		return profit;
    }
}
