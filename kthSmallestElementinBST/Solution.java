package kthSmallestElementinBST;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
    	if (root == null)
    		return 0;
    	
        int leftSize = getTreeSize(root.left);
        if (leftSize == k - 1)
        	return root.val;
        if (leftSize > k - 1)
        	return kthSmallest(root.left, k);
        else
        	return kthSmallest(root.right, k - leftSize - 1);
        	
    }
    
    public int getTreeSize(TreeNode root) {
    	if (root == null)
    		return 0;
    	return 1 + getTreeSize(root.left) + getTreeSize(root.right);
    }
}




class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode (int x) {
		val = x;
	}
}