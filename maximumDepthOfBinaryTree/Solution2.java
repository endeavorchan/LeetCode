package maximumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	public int maxDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int currLevel = 0;
		int nextLevel = 0;
		int depth = 0;
		
		
		if (root == null)
			return 0;
		
		currLevel = 1;
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			
			if (currNode.left != null) {
				queue.offer(currNode.left);
				nextLevel++;
			}
			if (currNode.right != null) {
				queue.offer(currNode.right);
				nextLevel++;
			}
			
			currLevel--;
			if (currLevel == 0) {
				depth++;
				currLevel = nextLevel;
				nextLevel = 0;
			}
		}
		return depth;
	}
}
