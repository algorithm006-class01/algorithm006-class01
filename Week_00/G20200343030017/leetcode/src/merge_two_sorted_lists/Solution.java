package merge_two_sorted_lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempList = new ListNode(0);
        ListNode newList = tempList;
        while (l1 != null && l2 != null){
            if (l1.val<l2.val){
                tempList.next = l1;
                l1 = l1.next;
            }else{
                tempList.next = l2;
                l2 = l2.next;
            }
            tempList = tempList.next;
        }
        if (l1 != null)
            tempList.next = l1;
        if (l2 != null)
            tempList.next = l2;
        return newList.next;
    }
    public static void main(String[] args) {
        ListNode l1 =new ListNode(1);
        ListNode l3 =new ListNode(2);
        ListNode l5 =new ListNode(4);
        l1.next = l3;
        l3.next = l5;
        ListNode l2 =new ListNode(1);
        ListNode l4 =new ListNode(3);
        ListNode l6 =new ListNode(4);
        l2.next = l4;
        l4.next = l6;
        Solution solution = new Solution();
        solution.mergeTwoLists(l1,l2);
    }
}
