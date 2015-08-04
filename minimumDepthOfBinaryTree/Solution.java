package minimumDepthOfBinaryTree;

public class Solution {
    int minHeight = -1;
    public int minDepth(TreeNode root) {
    	if (root == null)
    		return 0;
        iterateTree(root, 1);
        return minHeight;
    }
	private void iterateTree(TreeNode root, int i) {
		if (root.left == null && root.right == null) {
			if (minHeight == -1)
				minHeight = i;
			else if (minHeight > i)
				minHeight = i;
		}
		if (root.left != null)
			iterateTree(root.left, i + 1);
		if (root.right != null)
			iterateTree(root.right, i + 1);
		
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	public TreeNode(int val) {
		this.val = val;
	}
}
