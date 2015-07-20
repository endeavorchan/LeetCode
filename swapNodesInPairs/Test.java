package swapNodesInPairs;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		Solution sol = new Solution();
		sol.swapPairs(n1);
	}

}
