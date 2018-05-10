package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/base-7/description/
 */

public class Base7 {
	public String convertToBase7(int num) {
		if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean negativeNum = false;
        if(num < 0) negativeNum = true;
        num = Math.abs(num);
        while(num!=0) {
        		sb.append(num%7);
        		num /= 7;
        }
		return negativeNum ? sb.reverse().insert(0, '-').toString() : sb.reverse().toString();
    }
}
