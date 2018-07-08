package medium;
/*
 * https://leetcode.com/problems/magical-string/description/
 */
public class MagicalString {
    public int magicalString(int n) {
    		//Base case
    		if(n==0) return 0;
    		if(n == 1 || n == 2) return 1;
    		
    		StringBuilder sb = new StringBuilder("122");
    		int index = 2, count = 1;
    		while(sb.length() < n) {
    			if(sb.charAt(index) == '1') {
    				if(sb.charAt(sb.length()-1) == '1') sb.append('2');
    				else {
    					sb.append('1');
    					count++;
    				}
    			}else {
    				if(sb.charAt(sb.length()-1) == '1') sb.append("22");
    				else {
    					sb.append("11");
    					count += 2;
    				}
    			}
    			index++;
    		}
    		if(sb.length() != n && sb.charAt(index-1) == '2' && sb.charAt(sb.length()-1) == '1') return count-1;
    		return count;
    }
}
