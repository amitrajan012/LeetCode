import java.util.Arrays;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		//Base case
		if(s.length() != t.length()) {
			return false;
		}
		int NO_OF_CHARS = 256;
		int count[] = new int [NO_OF_CHARS];
		Arrays.fill(count, 0);
		
        for(int i=0;i<s.length();i++) {
        		count[s.charAt(i)]++;
        		count[t.charAt(i)]--;
        }
        
        for(int i=0;i<count.length;i++) {
        		if(count[i] != 0) {
        			return false;
        		}
        }
        return true;
    }
}
