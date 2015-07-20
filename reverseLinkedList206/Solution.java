package reverseLinkedList206;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    static ListNode tail = null;
    public ListNode reverseList(ListNode head) {
        if (head == null) 
        	return null;
    	if (head.next == null)  {
        	tail = new ListNode(head.val);
        	return tail;
        }
        else {
        	ListNode retVal = reverseList(head.next);
        	ListNode newNode = new ListNode(head.val);
        	tail.next = newNode;
        	tail = newNode;
        	return retVal;
        }
    }
}

