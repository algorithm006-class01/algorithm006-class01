class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* temp=new ListNode(-1);
        ListNode* tmp=temp;

        
        while (l1!=NULL&&l2!=NULL)
        {
            /* code */if (l1->val<=l2->val)
            {
                /* code */tmp->next=l1;
                l1=l1->next;
            }else
            {
                tmp->next=l2;
                l2=l2->next;
            }
            tmp=tmp->next;
        }
        tmp->next=l1 != NULL?l1:l2;

        return temp->next;
        

    }
};
/*此方法为迭代方法*/