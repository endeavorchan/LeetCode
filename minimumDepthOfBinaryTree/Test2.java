package minimumDepthOfBinaryTree;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		Solution sol = new Solution();
		System.out.println(sol.minDepth(node1));
	}

}
