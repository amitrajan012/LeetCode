import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {
	public String reverseVowels(String s) {
        //Base case
		if(s == null || s.length() == 0 || s.length() == 1) {
			return s;
		}
		Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
		char[] chars = s.toCharArray();
		int start = 0;
		int end = s.length()-1;
		while(start<end) {
			if(!set.contains(chars[start])) {
				start++;
				continue;
			}
			if(!set.contains(chars[end])) {
				end--;
				continue;
			}
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
		return String.valueOf(chars);
    }
}
