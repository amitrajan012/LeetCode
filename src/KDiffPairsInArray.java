import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 * 
 */
public class KDiffPairsInArray {
	public int findPairs(int[] nums, int k) {
		//Base case
		if(nums == null || nums.length < 2 || k < 0) return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for(int num: nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			if(k == 0) {
				//Count entries with count greater or equal to 2
				if(e.getValue() >= 2)
					count++;
			}else {
				if(map.containsKey(e.getKey()+k))
					count++;
			}
		}
		return count;
    }
}
