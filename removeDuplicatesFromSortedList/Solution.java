package removeDuplicatesFromSortedList;


import java.util.HashSet;
import java.util.Set;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		Set<Integer> values = new HashSet<Integer>();
		ListNode i = head;
		ListNode pre = null;
		while (i != null) {
			if (values.contains(i.val) && pre != null) {
				pre.next = i.next;
				i = i.next;
			} else {
				values.add(i.val);
				pre = i;
				i = i.next;
			}
		}
		return head;
		
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode (int x) { val = x; } 
}