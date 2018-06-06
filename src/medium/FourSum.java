package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		    for(int i=0; i<nums.length; i++){
		        for(int j=i+1; j<nums.length-1; j++){
		            int l = j+1, r = nums.length -1;
		            while(l<r){
		                int sum = nums[i] + nums[j] + nums[l] + nums[r];
		                if(sum > target) {
		                		r--;
		                }
		                else if(sum < target) {
		                		l++;
		                }
		                else {
		                    ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
		                    //Code to avoid duplicates
		                    while(l<r && nums[l]==nums[l+1]) {
		                    		l++;
		                    }
		                    while(r>l && nums[r]==nums[r-1]) {
		                    		r--;
		                    }
		                    l++;
		                    r--;
		                }
		            }
		            //Code to avoid duplicates
		            while(j<nums.length-1 && nums[j]==nums[j+1]) {
		            		j++;
		            }
		        }
		        //Code to avoid duplicates
		        while(i<nums.length-1 && nums[i]==nums[i+1]) {
		        		i++;
		        }
		    }
		    return ans;
		}
}
