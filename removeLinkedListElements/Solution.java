package removeLinkedListElements;

public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		ListNode curr = head;
		while (curr != null) {
			if (curr.val == val) {
				pre.next = curr.next;
				curr = curr.next;
			} else {
				pre = curr;
				curr = curr.next;
			}
		}
		return fakeHead.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {val = x; }
}
