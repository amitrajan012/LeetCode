package medium;
/*
 * https://leetcode.com/problems/h-index-ii/description/
 */
public class HIndex2 {
    public int hIndex(int[] citations) {
    		int N = citations.length;
    		int start = 0, end = N-1;
    		while(start <= end) {
    			int mid = start+(end-start)/2;
    			if(N-mid == citations[mid]) return N-mid;
    			else if(N-mid < citations[mid]) end = mid-1;
    			else start = mid+1;
    		}
    		return N-start;
    }
}
