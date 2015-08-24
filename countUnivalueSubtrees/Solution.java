package countUnivalueSubtrees;

public class Solution {
	int countUniValue = 0;
    public int countUnivalSubtrees(TreeNode root) {
    	countUnivalSubtreesRecur(root);
    	return this.countUniValue;
    }
    
    public TreeNode countUnivalSubtreesRecur(TreeNode node) {
    	boolean isThisNodeUnivalue = true;
    	if (node == null)
    		return null;
    	if (node.left != null) {
    		TreeNode leftNode = countUnivalSubtreesRecur(node.left);
    		if (leftNode == null || leftNode.val != node.val) {
    			isThisNodeUnivalue = false;
    		}
    	}
    	
    	if (node.right != null) {
    		TreeNode rightNode = countUnivalSubtreesRecur(node.right);
    		if (rightNode == null || rightNode.val != node.val) {
    			isThisNodeUnivalue = false;
    		}
    	}
    	if (isThisNodeUnivalue) {
    		this.countUniValue++;
    		return new TreeNode(node.val);
    	}
    	else {
    		return null;
    	}
     }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) { val = x; }
}