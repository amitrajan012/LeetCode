package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        //Base case
        if(k <= 0 || nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new PairComparator());
        
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                    int[] temp = new int[]{nums1[i], nums2[j]};
                    queue.offer(temp);
            }
        }
        
        while(k>0 && queue.size()>0) {
        		res.add(queue.poll());
        		k--;
        }
        
    		return res;
    }
    
    class PairComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b)
        {
            return (a[0]+a[1]) - (b[0]+b[1]);
        }
    }
}
