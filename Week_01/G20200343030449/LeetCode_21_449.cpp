class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr) return l2;
        if (l2 == nullptr) return l1;

        ListNode* newHead = (l1->val < l2->val)?l1:l2;
        ListNode* sub = (newHead==l1)?l2:l1;
        ListNode* main = newHead;
        ListNode* last = main;

        while (main!=nullptr && sub!=nullptr) {
            if (main->val > sub->val) {
                last->next = sub;
                sub = sub->next;
                last->next->next = main;
                last = last->next;
            }
            else {
                last = main;
                main = main->next;
            }

        }

        if (sub!=nullptr) {
            last->next = sub;
        }

        return newHead;

    }
};
