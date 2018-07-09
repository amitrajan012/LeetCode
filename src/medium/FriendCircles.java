package medium;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for(int i=0;i<M.length;i++) {
        		if(visited[i] == 0) {
        			helper(M, visited, i);
        			count++;
        		}
        }
    		return count;
    }

	private void helper(int[][] M, int[] visited, int index) {
		//Implements dfs
		for(int j=0;j<M.length;j++) {
			if(M[index][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				helper(M, visited, j);
			}
		}
		
	}
}
