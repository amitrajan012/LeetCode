import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root == null){
			return result;
		}
		
		//Offer is used as it bypass capacity restrictions
		queue.offer(root);
		while(!queue.isEmpty()){
			int level = queue.size();
			List<Integer> temp = new LinkedList<Integer>();
			for(int i=0;i<level;i++){
				if(queue.peek().left != null){
					queue.offer(queue.peek().left);
				}
				if(queue.peek().right != null){
					queue.offer(queue.peek().right);
				}
				temp.add(queue.poll().val);
			}
			result.add(0, temp);
		}
		return result;
    }
}
