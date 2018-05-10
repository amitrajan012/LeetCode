package easy;
import java.util.HashMap;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> distinct = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			if(distinct.containsKey(nums[i])) {
				return true;
			}else {
				distinct.put(nums[i], 1);
			}
		}
		return false;
    }
}
