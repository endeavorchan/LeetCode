package reverseNodekGroup;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		Solution sol = new Solution();
		sol.reverseKGroup(n1, 3).print();;
		
	}

}
