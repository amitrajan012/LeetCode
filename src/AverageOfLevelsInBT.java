import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 */
public class AverageOfLevelsInBT {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<Double>();
		//Implementation of Breadth First/ Level Order Traversal
		//Push the root into the queue
		//Remove a node from the front of the queue
		//For every removed node from the queue, push it's children into a temporary queue
		//Pop nodes from the queue and add them into temporary queue until it's empty (count and sum can be tracked at this point)
		//Reinitialize the queue with the temporary queue
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			Queue<TreeNode> temp = new LinkedList<TreeNode>();
			double sum = 0, count = 0;
			while(!q.isEmpty()) {
				TreeNode t = q.poll();
				sum += t.val;
				count++;
				if(t.left != null) temp.add(t.left);
				if(t.right != null) temp.add(t.right);
			}
			if(count != 0.0) res.add(sum/count);
			q = temp;
		}
		return res;
    }
}
