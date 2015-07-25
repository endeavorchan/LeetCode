package postorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		stack.push(root);
		TreeNode prev = null;
		while (!stack.empty()) {
			
			TreeNode curr = stack.peek();
			// if go down 
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					result.add(curr.val);
				}
			} 
			// go up from left
			else if (curr.left == prev){
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					result.add(curr.val);
				}
			}
			// go up from right
			else if (curr.right == prev) {
				stack.pop();
				result.add(curr.val);
			}
			
			prev = curr;
		}
		return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}