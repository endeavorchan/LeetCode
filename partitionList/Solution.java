package partitionList;

public class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode fakeHead1 = new ListNode(0);
		ListNode fakeHead2 = new ListNode(0);
		
		ListNode p1 = fakeHead1;
		ListNode p2 = fakeHead2;
		
		if (head == null) 
			return null;
		ListNode p = head;
		while (p != null) {
			if (p.val < x) {
				p1.next = p;
				p1 = p1.next;
			} else {
				p2.next = p;
				p2 = p2.next;
			}
			
			p = p.next;
		}
		
		p1.next = fakeHead2.next;
		p2.next = null;
		return fakeHead1.next;
	}
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) { val = x; }
}