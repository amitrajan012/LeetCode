package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 *
 */
public class ConstructStringFromBinaryTree {
	StringBuilder sb= new StringBuilder();
	public String tree2str(TreeNode t) {
        traverseBT(t);
        return sb.toString();
	}
	
	private void traverseBT(TreeNode t) {
        if(t == null) {
            sb.append("");
            return;
        }
        sb.append(t.val);
        if(t.left == null && t.right == null) {
            return;
        }
        if(t.left != null) {
            sb.append("(");
            traverseBT(t.left);
            sb.append(")");
        } else {
            sb.append("()");
        }
        if(t.right != null) {
            sb.append("(");
            traverseBT(t.right);
            sb.append(")");
        }
	}
}
