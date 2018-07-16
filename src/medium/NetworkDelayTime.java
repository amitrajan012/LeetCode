package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/network-delay-time/description/
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
    		int[] dis = new int[N + 1];
    		Arrays.fill(dis, Integer.MAX_VALUE);
    		dis[K] = 0;
    		
    		for(int i=1;i<=N;i++) {
    			if(i != K) {
    				for(int[] edge: times) {
    					int u = edge[0];
    					int v = edge[1];
    					int w = edge[2];
    					if(dis[u] != Integer.MAX_VALUE && dis[u] + w < dis[v]) {
    						dis[v] = dis[u]+w;
    					}
    				}
    			}
    		}
    		
    		int res = Integer.MIN_VALUE;
    		for(int i=1;i<=N;i++) {
    			if(i != K) {
    				res = Math.max(res, dis[i]);
    			}
    		}
    		return res == Integer.MAX_VALUE ? -1 : res;
    }
}
