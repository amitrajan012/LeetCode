package medium;
/*
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 */
public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        //Base case
		if(root == null || root.left == null) {
			return;
		}
		//Assumption: Perfect Binary Tree
		root.left.next = root.right;
		//Next of root already populated
		if(root.next != null && root.right != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
		return;
    }
}
