
public class NumberOfSegmentsInString {
	public int countSegments(String s) {
		int segments = 0;
		for(int i=0;i<s.length(); i++) {
			if(s.charAt(i) != ' ' && (i == 0 || s.charAt(i-1) == ' ')) {
				segments++;
			}
		}
		return segments;
    }
}
