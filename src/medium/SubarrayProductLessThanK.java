package medium;
/*
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    		//Time limit exceeds
    		int count = 0;
        for(int start=0;start<nums.length;start++) {
        		int product = nums[start];
        		if(product < k) {
        			count++;
        			int pointer = start+1;
        			while(pointer < nums.length && product*nums[pointer] < k) {
        				product *= nums[pointer];
        				count++;
        				pointer++;
        			}
        		}
        }
    		return count;
    }
    
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
    		//Two pointer solution: Maintain a window of product of magnitude max k
    		int n = nums.length;
    		long product = 1l;
    		int left = 0, right = 0, count = 0;
    		while(right < n) {
    			product *= nums[right];
    			while(left <= right && product >= k) {
    				//Move the left pointer as product exceeds k
    				product /= nums[left];
    				left++;
    			}
    			count += right-left+1; //For each element added to the sub-array, count increases by total number of elements in the sub-array
    			right++;
    		}
    		return count;
    }
}
