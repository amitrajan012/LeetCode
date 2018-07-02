package medium;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
    		int n = matrix.length;
    		PriorityQueue<Tuple> pq = new PriorityQueue<>();
    		for(int i=0;i<n;i++) {
    			pq.offer(new Tuple(0,i, matrix[0][i]));
    		}
    		
    		for(int i=1;i<=k-1;i++) {
    			Tuple t = pq.poll();
    			if(t.x == n-1) continue; //As end of column is reached
    			pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
    		}
    		
    		return pq.poll().val;
    }
    
    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }
}
