package medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/dota2-senate/description/
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
    		Queue<Integer> radiant = new LinkedList<Integer>(), dire = new LinkedList<Integer>();
        int n = senate.length();
        for(int i = 0; i<n; i++){
            if(senate.charAt(i) == 'R')radiant.add(i);
            else dire.add(i);
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int r_index = radiant.poll(), d_index = dire.poll(); 
            //Add the senator for the next round of voting
            if(r_index < d_index)radiant.add(r_index + n);
            else dire.add(d_index + n);
        }
        return (radiant.size() > dire.size())? "Radiant" : "Dire";
    }
}
