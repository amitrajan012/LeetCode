package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/restore-ip-addresses/description/
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        //Base case
        if(s == null || s.length() == 0 || s.length() < 4) {
        		return res;
        }
        helper(res, s, 4, new ArrayList<String>());
		return null;
    }

	private void helper(List<String> res, String s, int left, List<String> list) {
		if(left == 1) {
			if(s != null && s.length() != 0 && (s.charAt(0) != '0' || s.length() == 1) && s.length() <= 3 && Integer.valueOf(s) <= 255) {
				//Valid IP Address found
				list.add(s);
				StringBuilder sb = new StringBuilder(); 
				for(String temp: list) {
					sb.append(temp);
					sb.append('.');
				}
				sb.setLength(sb.length() - 1);
				res.add(sb.toString());
			}
		}
		
		for(int i=1;i<=3 && i < s.length();i++) {
			int val = Integer.parseInt(s.substring(0, i));
			if(val > 255 || (i > 1 && s.charAt(0) == '0')) {
				break;
			}
			list.add(s.substring(0, i));
			helper(res, s.substring(i), left-1, list);
			list.remove(list.size()-1);
		}
		
	}
}
