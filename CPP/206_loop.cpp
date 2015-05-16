/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    
    ListNode* reverseList(ListNode* head) {
       if (head == NULL) 
           return NULL;
       ListNode *prenode1 = NULL;
       ListNode *prenode2 = NULL;
       while (head->next != NULL) {
           prenode2 = prenode1;
           prenode1 = head;
           head = head->next;
           prenode1->next = prenode2;
       }
       head->next = prenode1;
       return head;
    }
        
};