package sumRoot129;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSol {
	static TreeNode testNode;
	static Solution sol = new Solution();
	@Test
	public void test1() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node2.left = node3;
		testNode = node1;
		assertEquals(123, sol.sumNumbers(testNode));
		
	}
	@Test
	public void test2() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		testNode = node1;
		assertEquals(25, sol.sumNumbers(testNode));
	}

}
