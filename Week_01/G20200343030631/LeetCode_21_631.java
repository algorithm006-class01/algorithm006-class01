
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 递归思想，对两个链表元素挨个处理
     * 时间复杂度：O（n+m）
     * 空间复杂度：O(n+m)
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :41 MB, 在所有 Java 提交中击败了5.02%的用户
     */
    public ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
        // 边界判断及递归终止条件，如果l1 l2任何一个为空，直接返回另一个即可；
        if (null == l1){
            return l2;
        }
        if (null == l2){
            return l1;
        }
        // 递归处理，如果当前l1节点值小于l2，则l1为当前节点，继续合并l1.next与l2，对l2也是一样
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 解题思路: 迭代方式，新建空链表，比较两个链表元素后放入新链表，两个链表指针逐步后移
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(1)
     * 执行用时: 1 ms, 在所有 Java 提交中击败了87.80%的用户
     * 内存消耗: 41 MB, 在所有 Java 提交中击败了5.02%的用户
     *
     * @Author: loe881@163.com
     * @Date: 2020/2/18
     */
    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        // 新建两个节点，一个作为head，一个作为游标
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
            // 指向每次循环的最后一个节点
            prev = prev.next;
        }
        // 如果循环停止后，l1 l2中有一个不为空，则直接附加在最后
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}