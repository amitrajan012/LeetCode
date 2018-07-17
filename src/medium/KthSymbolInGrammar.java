package medium;
/*
 * https://leetcode.com/problems/k-th-symbol-in-grammar/description/
 */
public class KthSymbolInGrammar {
    public int kthGrammar(int N, int K) {
    		//Memory Limit exceeds
        if(N == 1 && K == 1) return 0;
        if(N == 2) return K == 0 ? 0 : 1;
        
        StringBuilder sb = new StringBuilder("01");
        int row = 2;
        while(row <= N) {
        		String s = sb.toString();
        		for(int i=0;i<s.length();i++) {
        			sb.append(s.charAt(i) ^ '1');
        		}
        		if(sb.length() >= K) return sb.charAt(K-1) == '0' ? 0: 1;
        		row++;
        }
        
        return sb.charAt(K-1) == '0' ? 0: 1;
    }
    
    public int kthGrammar1(int N, int K) {
        if (N == 1) return 0;

        if (K % 2 == 0) {
            if (kthGrammar(N-1, K/2) == 0) return 1;
            else return 0;
        } else {
            if (kthGrammar(N-1, (K+1)/2) == 0) return 0;
            else return 1;
        }
    }
}
