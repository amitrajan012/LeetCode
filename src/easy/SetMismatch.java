package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/set-mismatch/description/
 *
 */
public class SetMismatch {
	public int[] findErrorNums(int[] nums) {
		boolean[] set = new boolean[nums.length+1];
		int dup = 0;
		for(int num: nums) {
			if(set[num])
				dup = num;
			set[num] = true;
		}
		for(int i=1;;i++) {
			if(!set[i]) return new int[] {dup, i};
		}
	}
}
