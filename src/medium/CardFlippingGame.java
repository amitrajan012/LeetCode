package medium;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/card-flipping-game/description/
 */
public class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        //If front and back are same on a particular card, that number can't be good as if that card is chosen the number on it's back will always be on it's front
    		//If front != back for some particular card and the number is not in the set of numbers (front == back) who will always appear on front of a card, add them
    		//to the possible candidate 
    		Set<Integer> set = new HashSet<>();
    		for(int i=0;i<fronts.length;i++) {
    			if(fronts[i] == backs[i]) set.add(fronts[i]);
    		}
    		
    		int res = Integer.MAX_VALUE;
    		for(int i=0;i<fronts.length;i++) {
    			if(!set.contains(fronts[i])) res = Integer.min(res, fronts[i]);
    			if(!set.contains(backs[i])) res = Integer.min(res, backs[i]);
    		}
    		return res == Integer.MAX_VALUE ? 0: res;
    }
}
