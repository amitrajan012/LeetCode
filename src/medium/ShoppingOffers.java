package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/shopping-offers/description/
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    		return helper(price, special, needs, 0);
    }
    
    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
    		int min = directPurchase(price, needs); //Evaluate cost by purchasing remaining items directly
    		for(int i=pos;i<special.size();i++) {
    			List<Integer> offer = special.get(i);
    			List<Integer> temp = new ArrayList<>();
    			for(int j=0;j<needs.size();j++) {
    				if(needs.get(j) < offer.get(j)) { //Offer can not be selected
    					temp = null;
    					break;
    				}
    				temp.add(needs.get(j) - offer.get(j)); //Construct new list of remaining needs
    			}
    			
    			if(temp != null) { //Use current offer and try next
    				min = Math.min(min, offer.get(offer.size()-1)+helper(price, special, temp, i));
    			}
    		}
		return min;
	}

	private int directPurchase(List<Integer> price, List<Integer> needs) {
    		int total = 0;
    		for (int i = 0; i < needs.size(); i++) {
    			total += price.get(i) * needs.get(i);
    		}
    	
    		return total;
    }
}
