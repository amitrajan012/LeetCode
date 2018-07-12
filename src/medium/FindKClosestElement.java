package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-k-closest-elements/description/
 */
public class FindKClosestElement {
	List<Integer> res = new ArrayList<>();
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(k==0) return res;
        
        //Find the least index in arr at which the element is greater than x
        int index = 0;
        while(index < arr.length && arr[index] < x) {
        		index++;
        }
        
        if(index == 0) {
        		//Add first k elements
        		for(int i=0;i<k;i++)
        			res.add(arr[i]);
        }else if(index == arr.length) {
        		//Add last k elements
        		for(int i=arr.length-k;i<arr.length;i++)
        			res.add(arr[i]);
        }else {
        		if(arr[index] == x) {
        			res.add(arr[index]);
        			helper(arr, index-1, index+1, k-1, x);
        		}else {
        			helper(arr, index-1, index, k, x);	
        		}
        }
    		return res;
    }

	private void helper(int[] arr, int left, int right, int remainingElements, int x) {
		if(remainingElements == 0) return;
		
		boolean addLeft = false, addRight = false;
		if(left >= 0) {
			addLeft = true;
		}
		if(right < arr.length) {
			if(left < 0) {
				addRight = true;
			}else if(arr[right] - x < x - arr[left]) {
				//Preference to smaller element
				addLeft = false;
				addRight = true;
			}
		}
		
		if(addRight) {
			res.add(arr[right]);
			right++;
		}else if(addLeft) {
			res.add(0, arr[left]);
			left--;
		}
		helper(arr, left, right, remainingElements-1, x);
	}
}
