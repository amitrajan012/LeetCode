package easy;

public class StringCompression {
	public int compress(char[] chars) {
		int indexAns = 0, index = 0;
		while(index < chars.length) {
			char temp = chars[index];
			int count = 0;
			while(index < chars.length && chars[index] == temp) {
				count++;
				index++;
			}
			chars[indexAns++] = temp;
			if(count > 1) {
				for(char c : Integer.toString(count).toCharArray()) {
					chars[indexAns++] = c;
				}
			}
		}
		return indexAns;
	}
}
