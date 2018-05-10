package easy;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 *
 */
public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        for(int num: nums) {
        		map.put(num, map.getOrDefault(num, 0)+1);
        		if(map.containsKey(num+1))
        			result = Math.max(result, map.get(num)+map.get(num+1));
        		if(map.containsKey(num-1))
        			result = Math.max(result, map.get(num)+map.get(num-1));
        }
		return result;
    }
}
