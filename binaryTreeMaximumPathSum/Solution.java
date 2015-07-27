package binaryTreeMaximumPathSum;

public class Solution {
    public int maxPathSum(TreeNode root) {
    	if (root == null)
    		return 0;
    	if (root.left == null && root.right == null) {
    		return root.val;
    	}
    	int maxSubPath;
    	if (root.left == null || root.right == null) {
    		maxSubPath = (root.left == null) ? maxPathSum(root.right) : maxPathSum(root.left);
    	}
    	else 
    	   maxSubPath = Math.max(maxPathSum(root.left), maxPathSum(root.left));
        int temp =  Math.max(maxSubPath, maxHalfPath(root.right) + maxHalfPath(root.left) + root.val);
        temp = Math.max(root.val, temp);
        return temp;
    }
    public int maxHalfPath(TreeNode root) {
    	if (root == null)
    		return 0;
    	int maxSubPath = Math.max(maxHalfPath(root.left), maxHalfPath(root.right));
    	
    	int temp = Math.max(maxHalfPath(root.left), maxHalfPath(root.right)) + root.val;
    	
    	return temp;
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
