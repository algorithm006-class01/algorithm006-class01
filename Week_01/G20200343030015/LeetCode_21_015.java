package G20200343030015.week_01;

/**
 * Created by majiancheng on 2020/2/16.
 */
public class LeetCode_21_015 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        if (l1 != null) {
            prev.next = l1;
        } else {
            prev.next = l2;
        }

        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1Head = l1;
        for (int i = 2; i < 5; i++) {
            l1.next = new ListNode(i);
            l1 = l1.next;
        }

        ListNode l2 = new ListNode(2);
        ListNode l2Head = l2;
        for (int i = 3; i < 5; i++) {
            l2.next = new ListNode(i);
            l2 = l2.next;
        }

        ListNode newHead = new LeetCode_21_015().mergeTwoLists(l1Head, l2Head);
        while (newHead != null) {
            System.out.print(newHead.val + ", ");
            newHead = newHead.next;
        }

    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
