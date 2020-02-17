/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
//21 merge-two-sorted-lists,    LeetCode_21_451.c

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    if ( l1 == NULL ) return l2;
    if ( l2 == NULL ) return l1;

    struct ListNode newlist;
    struct ListNode* head = &newlist;

    while ( l1 && l2 ) {
        if ( l1->val < l2->val ) {
            head->next = l1;
            l1 = l1->next; 
        } else {
            head->next = l2;
            l2 = l2->next; 
        }
        head = head->next;
    }
    if ( l1 != NULL ) head->next = l1;
    if ( l2 != NULL ) head->next = l2;

    head = newlist.next;
    return head;
}