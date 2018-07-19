package medium;
/*
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/
 */
public class MinimumSwapsToMakeSequenceIncreasing {
    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[N]; //Stores minimum swap needed to make the sequence till i increasing given we swap the number at i
        int[] notSwap = new int[N]; //Stores minimum swap needed to make the sequence till i increasing given we do not swap the number at i
        swap[0] = 1;
        for(int i=1;i<N;i++) {
        		swap[i] = N; notSwap[i] = N; 
        		if(A[i-1] < A[i] && B[i-1] < B[i]) {
        			notSwap[i] = notSwap[i-1]; //No need to swap i, If i-1 are not swapped
        			swap[i] = swap[i-1]+1; //Swap i if and only if i-1 are swapped
        		}
        		if(A[i-1] < B[i] && B[i-1] < A[i]) {
        			notSwap[i] = Math.min(notSwap[i], swap[i-1]); //If i-1 are swapped, no need to swap i
        			swap[i] = Math.min(swap[i], notSwap[i-1]+1); //Swap i if and only if i-1 are swapped
        		}
        }
    		return Math.min(swap[N-1], notSwap[N-1]);
    }
}
