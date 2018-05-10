package easy;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		//Base Case
		if(s == null || s.length()==0) {
			return t.charAt(0);
		}
		if(s.length() == 1) {
			if(s.charAt(0) == t.charAt(0)) {
				return t.charAt(1);
			}else {
				return t.charAt(0);
			}
		}
        char addedCharcter = (char) (s.charAt(0) ^ s.charAt(1));
        for(int i=2;i<s.length();i++) {
        		addedCharcter = (char) (addedCharcter ^ s.charAt(i));
        }
        for(int i=0;i<t.length();i++) {
        		addedCharcter = (char) (addedCharcter ^ t.charAt(i));
        }
        return addedCharcter;
    }
}
