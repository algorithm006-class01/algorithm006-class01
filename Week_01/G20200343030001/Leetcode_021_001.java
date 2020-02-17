package Week_01;

public class Leetcode_021_001 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode res = new ListNode(0);
        ListNode p = l1, q = l2, cur = res;

        while (p != null && q != null) {
            int x = p.val;
            int y = q.val;

            if (x <= y) {
                cur.next = new ListNode(x);
                cur = cur.next;
                p = p.next;
            } else {
                cur.next = new ListNode(y);
                cur = cur.next;
                q = q.next;
            }
        }

        if (p == null) {
            cur.next = q;
        }

        if (q == null) {
            cur.next = p;
        }

        return res.next;
    }
}
