/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 */
public class SumOfSquareNumbers {
	public boolean judgeSquareSum(int c) {
		int l=0;
        int r=(int)(Math.sqrt(c));
        
        while(l<=r) {
            if( l*l + r*r < c ) {
                l++;
            }     
            else if( l*l + r*r > c ){
                r--;
            }
            else 
                return true;
            
        }
        return false;
    }

}
