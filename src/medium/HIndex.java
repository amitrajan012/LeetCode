package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/h-index/description/
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int N = citations.length;
        int h = 0;
        for(int c: citations) {
        		if(c >= N & N > h) {
        			h = N;
        		}
        		N--;
        }
        return h;
    }
}
