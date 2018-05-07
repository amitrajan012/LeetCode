import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
	//Lowercase letters only
	static final int MAX = 26;
	
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		//Base case
		if(s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) return list;
		int M = p.length();
        int N = s.length();
        
        char[] countP = new char[MAX];
        char[] countS = new char[MAX];
        for (int i = 0; i < M; i++)
        {
            (countP[p.charAt(i) - 'a'])++;
            (countS[s.charAt(i) - 'a'])++;
        }
        for(int i=M;i<N;i++) {
        		//Compare count of current window of text with counts of pattern for which anagram needs to be matched
        		if(compare(countP, countS)) {
        			list.add(i-M);
        		}
        		//Add current character to the window
        		countS[s.charAt(i) - 'a']++;
        		//Remove the first character of previous window
        		countS[s.charAt(i-M) - 'a']--;
        }
        
        //Check for the last window separately
        if(compare(countP, countS)) {
        		list.add(N-M);
        }
		return list;
    }
	
	static boolean compare(char arr1[], char arr2[])
    {
        for (int i = 0; i < 26; i++) {
        		if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
