package medium;
/*
 * https://leetcode.com/problems/utf-8-validation/description/
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        //Base case
    		if(data == null || data.length == 0) return true;
    		for(int i=0;i<data.length;) {
    			int val = data[i];
    			if((val & 128) == 0) {
    				//Valid one bit encoding: 0xxxxxxx
    				i++;
    				continue;
    			}else if((val & 224) == 192) {
    				//Check for 2 bit encoding: 110xxxxx 10xxxxxx
    				i++;
    				if(i >= data.length) return false;
    				if((data[i] & 192) != 128) return false;
    				i++;
    			}else if((val & 240) == 224) {
    				//Check for 3 bit encoding: 1110xxxx 10xxxxxx 10xxxxxx
    				i++;
    				if(i >= data.length) return false;
    				if((data[i] & 192) != 128) return false;
    				i++;
    				if(i >= data.length) return false;
    				if((data[i] & 192) != 128) return false;
    				i++;
    			}else if((val & 248) == 240) {
    				//Check for valid 4 bit encoding: 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
    				i++;
    				if(i >= data.length) return false;
    				if((data[i] & 192) != 128) return false;
    				i++;
    				if(i >= data.length) return false;
    				if((data[i] & 192) != 128) return false;
    				i++;
    				if(i >= data.length) return false;
    				if((data[i] & 192) != 128) return false;
    				i++;
    			}else {
    				return false;
    			}
    		}
    		return true;
    }
}
