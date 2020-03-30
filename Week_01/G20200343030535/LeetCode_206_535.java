package leetcode.Week01;

import java.util.List;

public class LeetCode_206_535 {

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 多new了一个节点
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = new ListNode(-1);
        while (head != null){
            /**保存pre后面的指针*/
            ListNode temNode = pre.next;
            pre.next =  new ListNode(head.val);
            pre.next.next = temNode;
            head = head.next;
        }
        return pre.next;
    }

    /**
     * 操作都是指针操作
     */
    public ListNode reverseList2(ListNode head) {
       ListNode prev = null;
       ListNode curr = head;
       while (curr != null){
           ListNode tempNode = curr.next;
           curr.next = prev;
           prev = curr;
           curr = tempNode;
       }
       return prev;
    }
}
