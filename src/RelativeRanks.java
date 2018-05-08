import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/relative-ranks/description/
 */
public class RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
		String[] result = new String[nums.length];
		Map<Integer, Integer> standings = new TreeMap<>();
		for(int i=0;i<nums.length;i++)
			standings.put(nums[i], i);
		int rank = nums.length;
		for(Map.Entry<Integer, Integer> e : standings.entrySet()){
            if(rank == 3)
            		result[e.getValue()] = "Bronze Medal";  //As value of the map is the index of the score
            else if(rank == 2)                
            		result[e.getValue()] = "Silver Medal";
            else if(rank == 1)
            		result[e.getValue()] = "Gold Medal";
            else
            		result[e.getValue()] = String.valueOf(rank);
            rank--; 
        }
		return result;
    }
}
