package medium;
/*
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 */
public class PopulatingNextRightPointersInEachNode2 {
	public void connect(TreeLinkNode root) {
        //Level Order Traversal
		while(root != null) {
			TreeLinkNode tempChild = new TreeLinkNode(0);
			TreeLinkNode currChild = tempChild;
			while(root != null) {
				if(root.left != null) {
					currChild.next = root.left;
					currChild = currChild.next;
				}
				if(root.right != null) {
					currChild.next = root.right;
					currChild = currChild.next;
				}
				root = root.next;
			}
			root = tempChild.next;
		}
    }
}
