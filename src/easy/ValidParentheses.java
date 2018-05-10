package easy;
import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s){
		//Use stack
		Stack<Character> st = new Stack<Character>(); 
		for(int i=0;i<s.length();i++){
			//If opening brace, push on stack
			Character d = s.charAt(i);
			System.out.println("D>>>>" +d);
			if(d == '(' || d == '{' || d == '['){
				st.push(s.charAt(i));
			}else{
				if(st.isEmpty()){
					return false;
				}
				Character c = st.pop();
				System.out.println("C>>>>" +c);
				switch(c){
				case '(':
					if(d != ')'){
						System.out.println("Inside case 1");
						return false;
					}else{
						break;
					}
				case '{':
					if(d != '}'){
						System.out.println("Inside case 2");
						return false;
					}else{
						break;
					}
				case '[':
					if(d != ']'){
						System.out.println("Inside case 3");
						return false;
					}else{
						break;
					}
				}
			}
		}
		
		if(st.isEmpty()){
			return true;	
		}else{
			return false;
		}
	}

}
