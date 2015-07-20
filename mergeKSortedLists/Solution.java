package mergeKSortedLists;

// time exceeds 
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode returnList = null;
    	if (lists == null || lists.length == 0)
    		return null;
    	boolean allNull;
    	ListNode returnLast = null;
    	do{
    		allNull = true;
    		int minValue = Integer.MAX_VALUE;
    		int minIndex = -1;
    		ListNode curr = null;
    		for (int i = 0; i < lists.length; i++) {
    			if (lists[i] != null) {
    				allNull = false;
    				if (lists[i].val < minValue) {
    					minValue = lists[i].val;
    					curr = lists[i];
    					minIndex = i;
    				}
    			}
    		}
    		if (curr != null) {
    			if (returnList == null) {
    				returnList = curr;
    				returnLast = curr;
    			}
    			else  {
    				returnLast.next = curr;
    				returnLast = curr;
    			}
    			
    			ListNode temp = curr.next;
    			curr.next = null;
    			lists[minIndex] = temp;
    		}
    	}while (!allNull);
    	return returnList;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
