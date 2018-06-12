package medium;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
        //A new node i can be added to the tree in three ways:
		//1) As the rightmost node of the BST till i-1, No of ways: dp[i-1]
		//2) As the root of the BST till i-1, No of ways: dp[i-1]
		//3) As the internal node, No of ways:  sum of (dp[j]*dp[(i-1)-j]); j = 1 to i - 2
		
		//Base case
		if(n < 1) return 0;
		int[] dp = new int[n+1];
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] += 2*dp[i-1];
			for(int j=1;j<=i-2;j++) {
				dp[i] += (dp[j]*dp[(i-1)-j]);
			}
		}
		return dp[n];
    }
}
