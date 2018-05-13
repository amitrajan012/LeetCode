package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/rotated-digits/description/
 *
 */

public class RotatedDigits {
	public int rotatedDigits(int N) {
		int count = 0;
		boolean validNumber = false;
		next:
		for(int i=1;i<=N;i++) {
			validNumber = false;
			int m=i;
			while(m>0) {
				int temp = i%10; 
				if(temp==2 || temp==5 || temp==6 || temp==9) {
					m = m/10;
					validNumber = true; //Digit change after flipping
				}else if(temp==0 || temp==1 || temp==8) {
					m = m/10;
				}else {
					//Not a good number and hence continue to the next
					continue next;
				}
			}
			if(validNumber) count++;
		}
		return count;
    }

}
