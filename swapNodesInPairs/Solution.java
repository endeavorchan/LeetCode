package swapNodesInPairs;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = head.next;
		ListNode first = head;
		ListNode second;
		ListNode next;
		while (first != null) {
			second = first.next;
			if (second == null)
				break;
			next = second.next;
			second.next = first;
			if (next == null || next.next == null)
				first.next = next;
			else 
				first.next = next.next;
			first = next;
		}
		return newHead;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
