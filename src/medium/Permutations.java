package medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
/*
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {
	//Method 1: Using next permutations (This method is too slow)
	public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        addNextPermutation(list, nums);
		return list;
    }
	
	private void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
            start++;
            end--;
		}
	}
	
	private void addNextPermutation(List<List<Integer>> list, int[] nums) {
		int firstIndex = -1;
		for(int i=nums.length-1;i>=1;i--) {
			if(nums[i] > nums[i-1]) {
				firstIndex = i-1;
				break;
			}
		}
		
		if(firstIndex == -1) {
			return;
		}else {
			int nextIndex = -1;
			for(int i=firstIndex+1;i<nums.length;i++) {
				if(nums[i] <= nums[firstIndex]) {
					nextIndex = i-1;
					break;
				}else{
                    nextIndex = i;
                }
			}
			//Swap the numbers
			int temp = nums[nextIndex];
			nums[nextIndex] = nums[firstIndex];
			nums[firstIndex] = temp;
			reverse(nums, firstIndex+1, nums.length-1);
			list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			addNextPermutation(list, nums);
		}
    }
	
	/***********************************/
	//Method 2: 
	public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
        		return null;
        }
        
        list.add(Arrays.asList(nums[0]));
        for(int i=1;i<nums.length;i++) {
        		buildList(list, nums[i]);
        }
		return list;
    }

	private void buildList(List<List<Integer>> list, int e) {
		List<List<Integer>> tempList = new ArrayList<List<Integer>>(list);
		for(List<Integer> l: tempList) {
			list.remove(l);
			for(int i=0;i<=l.size();i++) {
				List<Integer> temp = new ArrayList<Integer>(l);
				temp.add(i, e);
				list.add(temp);
			}
		}
	}
	
}
