package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/gray-code/description/
 */

/*
For example, following are steps for generating the 3-bit Gray code list from the list of 2-bit Gray code list.
L1 = {00, 01, 11, 10} (List of 2-bit Gray Codes)
L2 = {10, 11, 01, 00} (Reverse of L1)
Prefix all entries of L1 with ‘0’, L1 becomes {000, 001, 011, 010}
Prefix all entries of L2 with ‘1’, L2 becomes {110, 111, 101, 100}
Concatenate L1 and L2, we get {000, 001, 011, 010, 110, 111, 101, 100}
 */

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
       
        for(int i=0;i<(1<<n);i++) {
        		list.add(i^i>>1);
        }
       
		return list;
    }
}
