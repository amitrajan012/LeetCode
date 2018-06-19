package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 */
class WordDictionary {
    TrieNode head = null;
    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new TrieNode();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null)
            return;
        char [] toInsert = word.toCharArray();
        TrieNode node = head;
        for(char c: toInsert){
            if(!node.charToNode.containsKey(c)){
                TrieNode temp = new TrieNode();
                node.charToNode.put(c, temp);
                node = temp;
                
            } else 
                node = node.charToNode.get(c);
        }
        node.isEnd=true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
         if(word == null)
            return false;
        char [] toSearch = word.toCharArray();
        return searchHelper(0,head,toSearch);
        
    }
    
    private boolean searchHelper(int idx, TrieNode node, char[] toSearch){
        if(idx == toSearch.length)
            return node.isEnd;
        
        char c = toSearch[idx];
        
        if(c != '.'){ 
            if(!node.charToNode.containsKey(c))
                return false;
            return searchHelper(idx+1, node.charToNode.get(c), toSearch);  
        } 
            
        for(char ch : node.charToNode.keySet()){
            if(searchHelper(idx+1,node.charToNode.get(ch), toSearch))
                return true;          
        }
        
        return false;
        
        
    }
    class TrieNode{
        boolean isEnd = false;
        Map<Character, TrieNode> charToNode;
        public TrieNode(){
            charToNode = new HashMap<Character, TrieNode>();
        }
        
    }
}



/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */