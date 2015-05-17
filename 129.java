/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
import java.util.Stack;

public class Solution {
	int sum = 0;
	Stack<Integer> digits = new Stack<Integer>();
    public int sumNumbers(TreeNode root) {
    	traverse(root);
        return sum;
    }
	private void traverse(TreeNode root) {
	    if (root == null) return;
	    else if ((root.left == null) && (root.right == null)) { // leaf node
	    	digits.push(root.val);
	    	retriveNumber();
	    	digits.pop();
	    }
	    else {
	        digits.push(root.val);
	        traverse(root.left);
	        traverse(root.right);
	        digits.pop();
	    }
		
	}
	private void retriveNumber() {
		int num = 0;
		for(int i = 0; i < digits.size(); i++) {
			int currentDigit = digits.get(i);
			num = num * 10 + currentDigit;
		}
		sum += num;
		
	}
}
