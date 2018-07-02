package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */
class RandomizedSet {
	Map<Integer, Integer> indices;
	List<Integer> content;
	Random R;
    /** Initialize your data structure here. */
    public RandomizedSet() {
    		indices = new HashMap<>();	
    		content = new ArrayList<>();
    		R = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(indices.containsKey(val)) return false;
        else {
        		indices.put(val, content.size());
        		content.add(val);
        		return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(indices.containsKey(val)) {
        		int index = indices.get(val);
        		if(index < content.size()-1) {
        			content.set(index, content.get(content.size()-1));
        			indices.put(content.get(content.size()-1), index);
        		}
        		content.remove(content.size()-1);
        		indices.remove(val);
        		return true;
        }else return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return content.get(R.nextInt(content.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */