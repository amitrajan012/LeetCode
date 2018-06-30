package medium;
/*
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[] res = new int[n+1];
        //Base case
        if(n==0) return 1;
        if(n==1) return 10;
        if(n==2) return 91;
        res[1] = 10; res[2] = 81;
        int ans = res[1]+res[2];
        for(int i=3;i<=n;i++) {
        		if(i==11) break;
        		res[i] = res[i-1]*(11-i);
        		ans += res[i];
        }
        return ans;
    }
}
