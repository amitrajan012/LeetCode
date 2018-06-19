package medium;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int num: nums) {
        		minHeap.offer(num);
        		if(minHeap.size() > k) {
        			minHeap.poll();
        		}
        }
    		return minHeap.peek();
    }
}
