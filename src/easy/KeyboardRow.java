package easy;
import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
	public String[] findWords(String[] words) {
		 List<String> list = new ArrayList<String>();
	        for (int i = 0; i < words.length; i++) {
	            char[] tempStr = words[i].toCharArray();
	            if (tempStr.length <= 0) {
	                continue;
	            }
	            boolean isResult = true;
	            int old = getRowNum(tempStr[0]);
	            for (int j = 1; j < tempStr.length; j++) {
	                if (old != getRowNum(tempStr[j])) {
	                    isResult = false;
	                    break;
	                }
	            }
	            
	            if (isResult) {
	                list.add(words[i]);
	            }
	        }
	        
	        return list.toArray(new String[list.size()]);
    }
	
	private int getRowNum(char ch) {
        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";
        
        if (row1.indexOf(ch) >= 0) {
            return 0;
        }
        if (row2.indexOf(ch) >= 0) {
            return 1;
        }
        if (row3.indexOf(ch) >= 0) {
            return 2;
        }
        return -1;
    }
}
