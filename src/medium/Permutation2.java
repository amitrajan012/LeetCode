package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/permutations-ii/description/
 */
public class Permutation2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		
		if(nums == null || nums.length == 0) {
			return null;
		}
		
		set.add(Arrays.asList(nums[0]));
		for(int i=1;i<nums.length;i++) {
    			buildList(set, nums[i]);
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.addAll(set);
		return list;
    }

	private void buildList(Set<List<Integer>> set, int e) {
		Set<List<Integer>> tempList = new HashSet<List<Integer>>(set);
		for(List<Integer> l: tempList) {
			set.remove(l);
			for(int i=0;i<=l.size();i++) {
				List<Integer> temp = new ArrayList<Integer>(l);
				temp.add(i, e);
				set.add(temp);
			}
		}
	}
	
	/******************************************/
	//Method 2
	public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        backTrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
	
    public void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean []used){
        if(tempList.size()==nums.length){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i=0;i<nums.length;i++){
                if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) {
                		continue;
                	}
                used[i]=true;
                tempList.add(nums[i]);
                backTrack(list,tempList,nums,used);
                used[i]=false;
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
