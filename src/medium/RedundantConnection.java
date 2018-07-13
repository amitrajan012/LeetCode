package medium;
/*
 * https://leetcode.com/problems/redundant-connection/description/
 */
public class RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
	    int n = edges.length, i = 0;
	    int[] roots = new int[n+1];
	    for (int j = 0; j < n; ++j) roots[j] = j;
	    for (i = 0; i < n; ++i) {
	        int parent_a = find(edges[i][0], roots);
	        int parent_b = find(edges[i][1], roots);
	        if (parent_a != parent_b) roots[parent_a] = parent_b;
	        else break;
	    }
	    return edges[i];
	}

	private int find (int i, int[] roots) {
	    while (roots[i] != i) {
	        i = roots[i];
	    }
	    return i; 
	}
}
