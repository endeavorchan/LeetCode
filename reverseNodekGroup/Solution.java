/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package reverseNodekGroup; 

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      if (head == null)  
          return null;
      if (k == 1)
        return head;
      int i = k;
      //find new head;
      ListNode newHead = head;
      while (i > 1 && newHead != null) {
          newHead = newHead.next;
          i--;
      }
      if (newHead == null)
        return head;
      
      ListNode nextGroupStartAfterReverse = null;
      ListNode groupStart = head;
      ListNode groupNextStart;
      ListNode groupStartAfterReverse = newHead;
      ListNode curr;
      ListNode next;
      ListNode previous;
      
      while (groupStart != null ) {
          i = k;
          //find groupStartAfterReverse 
          groupStartAfterReverse = groupStart;
          while (i > 1 && groupStartAfterReverse != null) {
              groupStartAfterReverse = groupStartAfterReverse.next;
              i--;
          }
          if (groupStartAfterReverse == null)
            break;
          groupNextStart = groupStartAfterReverse.next;
          
          //reserve assume k > 2 
          curr = groupStart;
          previous = null;
          while (previous != groupStartAfterReverse) {
              if (previous == null) {
            	  previous = curr;
            	  curr = curr.next;
              } else {
            	  next = curr.next;
            	  curr.next = previous;
            	  previous = curr;
            	  curr = next;
              }
          }
          //find nextGroupStartAfterReverse
          nextGroupStartAfterReverse = groupNextStart;
          i = k;
          while (i > 1 && nextGroupStartAfterReverse != null) {
              nextGroupStartAfterReverse = nextGroupStartAfterReverse.next;
              i--;
          }
          if (nextGroupStartAfterReverse == null)
            nextGroupStartAfterReverse = groupNextStart;
          groupStart.next = nextGroupStartAfterReverse;
          groupStart = groupNextStart;
      }
      return newHead;
    }
    
 
}
class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
	}
	void print() {
		System.out.print(val + ",");
		if (next != null)
			next.print();
	}
}