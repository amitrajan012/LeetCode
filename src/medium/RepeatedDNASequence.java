package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 */
public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<String>();
        Set<String> repeated = new HashSet<String>();
        for(int i=10;i<=s.length();i++) {
        		String temp = s.substring(i-10, i);
        		if(!seen.add(temp)) {
        			repeated.add(temp);
        		}
        }
        return new ArrayList<String>(repeated);
    }
}
