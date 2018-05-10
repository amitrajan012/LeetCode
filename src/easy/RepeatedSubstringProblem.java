package easy;

public class RepeatedSubstringProblem {
	public boolean repeatedSubstringPattern(String s) {
        // Length of the repeated substring must divide the length of the string
		int len = s.length();
        outerloop:
		for(int i = len/2;i>=1;i--) {
			if(len%i == 0) {
				int count = len/i;
				String sub = s.substring(0, i);
				for(int j=1;j<=count;j++) {
					if(!(s.substring((j-1)*i, j*i)).equals(sub)) {
						continue outerloop;
					}
				}
				return true;
			}
		}
		return false;
    }
}
