package sumRootToLeafNumbers;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) 
        	return 0;
        return dfs(root, 0, 0);
    }
    
    public int dfs(TreeNode node, int num, int sum) {
    	// num is the current number
    	// convert to number then add them up
    	if (node == null) 
    		return sum;
    	num = num * 10 + node.val;
    	
    	if (node.left == null && node.right == null) {
    		sum += num;
    		return sum;
    	}
    	
    	sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
    	return sum;
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