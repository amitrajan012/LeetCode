package medium;

public class ValidParanthesisString {
    public boolean checkValidString(String s) {
        int open = 0, filler = 0;
        for(char c: s.toCharArray()) {
        		if(c == '(') open++;
        		else if(c == ')') {
        			if(open > 0) open--;
        			else {
        				if(filler > 0) filler--;
        				else return false;
        			}
        		}else {
        			filler++;
        		}
        }
        
        if(open == 0) return true;
        //Closing braces are taken care of
        //We need to deal with opening braces
        open = 0;
        for(char c: s.toCharArray()) {
        		if(c == '(') open++;
        		else if(open > 0) open--;
        }
    		return (open == 0);
    }
}
