package medium;
/*
 * https://leetcode.com/problems/longest-mountain-in-array/description/
 */
public class LongestMountainInArray {
    public int longestMountain(int[] A) {
    		int res = 0;
        for(int i=1;i<=A.length-2;i++) {
        		int left = i-1, right = i+1;
        		if(A[left] < A[i] && A[right] < A[i]) {
        			int len = 3;
        			int leftValue = A[left], rightValue = A[right];
        			left--; right++;
        			while(left >= 0 && A[left] < leftValue) {
        				leftValue = A[left];
        				len++; left--;
        			}
        			while(right <= A.length-1 && A[right] < rightValue) {
        				rightValue = A[right];
        				len++; right++;
        			}
        			res = Math.max(res, len);
        		}
        		
        }
    		return res;
    }
}
