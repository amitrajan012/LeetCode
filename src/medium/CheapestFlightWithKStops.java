package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 */
public class CheapestFlightWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        for(int i=0;i<=K;i++) {
        		int[] temp = Arrays.copyOf(prices, n);
        		for(int[] flight: flights) {
        			int source = flight[0], destination = flight[1], price = flight[2];
        			if(prices[source] != Integer.MAX_VALUE) {
        				temp[destination] = Math.min(temp[destination], prices[source] + price);
        			}
        		}
        		prices = temp;
        }
    		return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
