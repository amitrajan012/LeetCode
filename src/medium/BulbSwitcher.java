package medium;
/*
 * https://leetcode.com/problems/bulb-switcher/description/
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        //The bulb whose number are perfect squares will be ON
    		int res = 0, i = 1;
    		while(i*i <= n) {
    			res++;
    			i++;
    		}
    		return res;
    }
    
    public int bulbSwitch1(int n) {
    		return (int)Math.sqrt(n);
    }
}
