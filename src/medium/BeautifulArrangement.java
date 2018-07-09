package medium;
/*
 * https://leetcode.com/problems/beautiful-arrangement/description/
 */
public class BeautifulArrangement {
	int count = 0;
    public int countArrangement(int N) {
        helper(N, N, new boolean[N+1]);
    		return count;
    }
	private void helper(int N, int index, boolean[] visited) {
		if(index == 0) {
			count++;
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(visited[i] || (index%i != 0 && i%index != 0)) {
				continue;
			}
			visited[i] = true; //Position i is filled
			helper(N, index-1, visited);
			visited[i] = false;
		}
	}
}
