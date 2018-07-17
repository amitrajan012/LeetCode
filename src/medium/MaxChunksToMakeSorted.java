package medium;
/*
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
    		//Algorithm: Iterate through the array, each time all elements to the left are smaller (or equal) to all elements to the right, there is a new chunck.
    		int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];
        
        maxOfLeft[0] = arr[0];
        for(int i=1;i<n;i++) {
        		maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }
        
        minOfRight[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) {
        		minOfRight[i] = Math.min(minOfRight[i+1], arr[i]);
        }
        
        int res = 0;
        for(int i=0;i<n-1;i++) {
        		if(maxOfLeft[i] <= minOfRight[i+1]) res++;
        }	
        
        return res+1;
    }
}
