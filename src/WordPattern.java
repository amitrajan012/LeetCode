import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	@SuppressWarnings("unchecked")
	public boolean wordPattern(String pattern, String str) {
		String[] elements = str.split(" ");
		//Base case
		if(pattern.length() != elements.length) {
			return false;
		}
		
		@SuppressWarnings("rawtypes")
		Map index = new HashMap();
		for(Integer i=0;i<elements.length;i++) {
			if (index.put(pattern.charAt(i), i) != index.put(elements[i], i)) {
				   return false;	
			} 
		}
		return true;
    }
}
