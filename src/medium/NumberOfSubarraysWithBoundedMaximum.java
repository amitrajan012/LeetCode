package medium;
/*
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
 */
public class NumberOfSubarraysWithBoundedMaximum {
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j=0,count=0,res=0; //j is used to keep track of the end index of valid sub array
        
        for(int i=0;i<A.length;i++){
            if(A[i]>=L && A[i]<=R){
                res+=i-j+1;count=i-j+1; //The sub array is valid hence add the count
            }
            else if(A[i]<L){
                res+=count; //Last element is less than L and hence add previous sub array
            }
            else{ //Reset the index and count
                j=i+1;
                count=0;
            }
        }
        return res;
    }
}
