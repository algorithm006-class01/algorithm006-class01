package Week_01.G20200343030395;

import java.util.List;

public class LeetCode_141 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p =  new ListNode(2);
        head.next = p;
        p.next = null;

        boolean bool = hasCycle(head);
        System.out.print(bool);

    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode p = head;
        ListNode q = head.next;

        while(p != q) {
            if(q.next == null || q.next.next == null){
                return false;
            }

            p = p.next;
            q = q.next.next;
        }

        return true;
    }
}



