
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        int firstZeroPointer = -1;
        for(int i=0;i<nums.length;i++) {
        		if(nums[i] != 0) {
        			if(firstZeroPointer>=0) {
        				//Replace the number with the 0 at the firstZeroPointer
            			nums[firstZeroPointer] = nums[i];
            			nums[i] = 0;
            			//Increment the zero pointer by 1
            			firstZeroPointer++;
        			}
        		}else {
        			if(firstZeroPointer < 0) {
        				firstZeroPointer = i;
        			}
        		}
        }
    }
}
