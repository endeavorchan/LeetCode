package binaryTreeMaximumPathSum;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n2.left = n3;
		Solution sol = new Solution();
		System.out.println(sol.maxPathSum(n1));
	}
	
	@org.junit.Test
	public void test2() {
		TreeNode n1 = new TreeNode(-3);
		//TreeNode n2 = new TreeNode(2);
		//TreeNode n3 = new TreeNode(3);
		//n1.left = n2;
		//n2.left = n3;
		Solution sol = new Solution();
		System.out.println(sol.maxPathSum(n1));
	}

}
