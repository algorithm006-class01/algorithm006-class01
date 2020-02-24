class Solution {
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     // 复杂度  time O(n)  space O(1)
    //     ListNode dummy = new ListNode(-1);
    //     ListNode head = dummy;
    //     ListNode a1 = l1;
    //     ListNode a2 = l2;
    //     while(a1!=null && a2!=null){
    //         if(a1.val <= a2.val){
    //             dummy.next = a1;
    //             a1 = a1.next;
    //         }else{
    //             dummy.next = a2;
    //             a2 = a2.next;
    //         }
    //         dummy = dummy.next;
    //     }

    //     // while(a1!=null){
    //     //     dummy.next = a1;
    //     //     a1 = a1.next;
    //     //     dummy = dummy.next;
    //     // }
    //     // while(a2!=null){
    //     //     dummy.next = a2;
    //     //     a2 = a2.next;
    //     //     dummy = dummy.next;
    //     // }
    //     // dummy.next = null;
    //     //优化
    //     dummy.next = (a1 !=null) ? a1:a2;
    //     return head.next;
    // }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}