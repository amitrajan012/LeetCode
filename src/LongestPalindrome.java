
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] upperCase = new int[26];
        int[] lowerCase = new int[26];
        for(int i=0;i<s.length();i++) {
        		if(Character.isUpperCase(s.charAt(i))) {
        			upperCase[(int)s.charAt(i) - 65] += 1;
        		}else {
        			lowerCase[(int)s.charAt(i) - 97] += 1;
        		}
        }
        
        //Evaluate the sum and find the count of odd characters as well
        //We have to leave all the odd characters except 1
        int sum = 0;
        int countOdd = 0;
        for(int i=0;i<upperCase.length;i++) {
        		sum = sum + upperCase[i] + lowerCase[i];
        		if(upperCase[i] % 2 != 0) {
        			countOdd++;
        		}
        		if(lowerCase[i] % 2 != 0) {
        			countOdd++;
        		}
        }
    		return sum-(countOdd == 0 ? 0:countOdd-1);
    }
}
