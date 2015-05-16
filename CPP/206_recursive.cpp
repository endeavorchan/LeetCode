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
        if (head == NULL) {
            return NULL;
        } else if (head->next == NULL){
        
            return head;
        } else {
            ListNode* ret = reverseList(head->next);
            if (head->next) {
                head->next->next = head;
                head->next = NULL;
            }
            return ret;
        }
    }
        
};