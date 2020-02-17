package homework.week_01;

public class LeetCode_21_365 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode lv = new ListNode(-1);

        //保存头
        ListNode pre = lv;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                lv.next = l1;
                l1 = l1.next;
            }else{
                lv.next = l2;
                l2 = l2.next;
            }
            lv = lv.next;
        }

        lv.next = l1 == null ? l2 : l1;

        return pre.next;

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
