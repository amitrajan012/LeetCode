package easy;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] nums, int target){
		Map <Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<nums.length;i++){
			map.put(nums[i], i);
		}
		
		for(int i=0; i<nums.length;i++){
			if(map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
				return new int[]{i, map.get(target-nums[i])};
			}
		}
		throw new IllegalArgumentException("No two sum solution");	
	}

}
