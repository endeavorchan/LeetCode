package binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		List<String> current = new ArrayList<String>();
		dfs(result, current, root);
		return result;
	}
	
	public void dfs(List<String> result, List<String> current, TreeNode node) {
		if (node == null) {
			return;
		}
		
		if (current.size() == 0) {
			current.add("" + node.val);
		}
		else {
			current.add("->" + node.val);
		}
		if (node.left == null && node.right == null) {
			StringBuilder path = new StringBuilder();
			
			for (int i = 0; i < current.size(); i++) {
				path.append(current.get(i));
			}
			
			String newPath = path.toString();
			result.add(newPath);
		}
		
		if (node.left != null) {
			dfs(result, current, node.left);
		}
		
		if (node.right != null) {
			dfs(result, current, node.right);
		}
		
		current.remove(current.size() - 1);
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int x) {
		val = x;
	}
}
