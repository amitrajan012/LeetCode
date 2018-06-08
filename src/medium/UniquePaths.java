package medium;
/*
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		//Time limit exceeds 
        if(m == 1 || n == 1) {
        		return 1;
        }
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
	
	public int uniquePaths2(int m, int n) {
		//To reach m,n; We need to do m-1 down and n-1 right movements, i.e. a total of m-n-2 movements
		//Hnece all the down movements can be chosen in (m-n-2)C(m-1) ways
        int N = m+n-2;
        int k = Math.min(m-1, n-1);
        //Find NCk
        double res = 1;
        for(int i=1;i<=k;i++) {
        		res = res * (N - k + i) / i;
        }
        return (int)res;
    }
}
