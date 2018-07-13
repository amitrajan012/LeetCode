package medium;
/*
 * https://leetcode.com/problems/beautiful-arrangement-ii/description/
 */
public class BeautifulArrangement2 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1, right = n;
        for (int i = 0; left <= right; i++) {
        		if(k>1) {
        			//For getting k different differences, alternate the elements from the start and the end until k-1 differences are met
        			//Add remaining elements in ascending order
        			if(k%2 != 0) {
        				//Add from start at odd position
        				res[i] = left;
        				left++;
        			}else {
        				//Add from end
        				res[i] = right;
        				right--;
        			}
        			k--;
        		}else {
        			//Add elements in ascending order
        			res[i] = left;
    				left++;
        		}
        }
            
        return res;
    }
}
