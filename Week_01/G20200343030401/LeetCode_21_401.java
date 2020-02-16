//题目链接: https://leetcode-cn.com/problems/merge-two-sorted-lists/

class Solution {
    /**
     * 方法1: 递归
     * 时间复杂度O(n+m): 每次递归去掉l1或者l2的头元素，函数遍历每个元素一次
     * 空间复杂度O(n+m): l1和l2每个元素遍历过一次,n+m个栈帧消耗O(n+m)空间
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    /**
     * 方法2: 迭代
     * 时间复杂度O(n+m): 每次迭代只能合并l1或者l2的其中一个元素，while循环次数等于两个链表总长度
     * 空间复杂度O(1): 迭代过程中产生几个指针，所需的空间是常数级别的
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
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

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}