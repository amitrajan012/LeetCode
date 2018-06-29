package medium;

/*
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 */
public class VerifyPreOrderSerializationofBT {
    public boolean isValidSerialization(String preorder) {
    		//Base case
    		if(preorder == null || preorder.length() == 0) return true;
    		//all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
    		//all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
    		//diff = outdegree - indegree 
    		//diff should never be negative and should be equal to 0 when traversal is finished
    		//diff should not be 0 until all the nodes are traversed as well 
        String[] nodes = preorder.split(",");
        if(nodes[0].equals("#")) {
        		if(nodes.length == 1) return true;
        		else return false;
        }
        int diff = 2; //Difference between outdegree and indegree (for root it is 2)
        for(int i=1;i<nodes.length;i++) {
        		if(nodes[i].equals("#")) diff--;
        		else diff++;
        		if(diff < 0) return false;
        		else if(diff == 0 && i != nodes.length-1) return false;
        }
    		return (diff == 0);
    }
}
