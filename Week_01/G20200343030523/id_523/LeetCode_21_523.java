package linkedlist;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode pos = head;

        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pos.next = p1;
                p1 = p1.next;
            } else if (p2.val < p1.val) {
                pos.next = p2;
                p2 = p2.next;
            }
            pos = pos.next;
        }

        while (p1 != null) {
            pos.next = p1;
            pos = pos.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            pos.next = p2;
            pos = pos.next;
            p2 = p2.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode l1 = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        ListNode l2 = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l3 = mergeTwoSortedLists.mergeTwoLists(l1, null);
    }

}
