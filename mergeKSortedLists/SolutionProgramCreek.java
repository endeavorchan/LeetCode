package mergeKSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;



public class SolutionProgramCreek {
	public ListNode mergeKLists(ListNode[] lists) {
		
		ArrayList<ListNode> listsArrayList = new ArrayList<ListNode>();
		if (lists == null)
			return null;
		for (int i = 0; i < lists.length; i++) 
			listsArrayList.add(lists[i]);
		
		if (listsArrayList.size() == 0)
			return null;
		
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(listsArrayList.size(), 
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if (a.val == b.val)
							return 0;
						else 
							return -1;
					}
		});
		
		for (ListNode list : listsArrayList) {
			if (list != null)
				q.add(list);
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		while (q.size() > 0) {
			ListNode temp = q.poll();
			p.next = temp;
			
			if (temp.next != null)
				q.add(temp.next);
			p = p.next;
		}
		
		return head.next;
	}
}
