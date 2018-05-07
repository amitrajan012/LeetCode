
public class ReverseString {
	public String reverseString(String s) {
		StringBuilder reversed = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			reversed.append(s.charAt(s.length()-1-i));
		}
		return reversed.toString();
    }
}
