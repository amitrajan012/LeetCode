package medium;
/*
 * https://leetcode.com/problems/multiply-strings/description/
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		//Base case
		if(num1.compareTo("0") == 0 || num2.compareTo("0") == 0) {
			return new String("0");
		}
		
		int m = num1.length(), n = num2.length();
		int[] pos = new int[m+n];
		
		//      		123	 index of 2: 1
		//			 45  index of 4: 0
		//		-------------
		//			 15
		//			10
		//		   05
		//		  12
		//		 08		index of 08 : 1 and 2 (i+j, i+j+1)	: mul and add to previous val of A[i+j+1], Store carry in A[i+j]
		//		04
		//	---------------------
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				int mul = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
				int p1 = i+j, p2 = i+j+1;
				int sum = mul+pos[p2];
				
				pos[p1] += sum / 10;
	            pos[p2] = (sum) % 10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int p: pos) {
			if(!(sb.length() == 0 && p == 0)) {
				sb.append(p);
			}
		}
		return sb.length() == 0 ? "0" : sb.toString();
    }
}
