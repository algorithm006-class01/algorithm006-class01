/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 头结点
        ListNode prehead = new ListNode(-1);
        // 指针
        ListNode prev = prehead;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        while (l1 != null){
            prev.next = l1;
            l1 = l1.next;
            prev = prev.next;
        }

        while (l2 != null){
            prev.next = l2;
            l2 = l2.next;
            prev = prev.next;
        }

        // 简洁写法
        // prev.next = l1 == null ? l2 : l1;
        
        return prehead.next;
    }
}
// @lc code=end

