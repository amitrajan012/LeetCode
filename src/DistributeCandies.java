import java.util.HashSet;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/distribute-candies/description/
 *
 */
public class DistributeCandies {
	public int distributeCandies(int[] candies) {
        int max = candies.length/2;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<candies.length;i++) {
        		set.add(candies[i]);
        		if(set.size() >= max) 
        			return max;
        }
		return set.size();
    }
}
