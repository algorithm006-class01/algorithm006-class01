/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 思路分析: 
 * 创建一个新的列表,遍历链表1和链表2,分别比较每个节点的大小放入融合列表中
 *
 * 注意事项: 
 * 1. 创建一个新的列表headNode 
 * 2. curMerge指向头节点且不断的向后遍历指向新的节点 保存链表1和链表2的较小的值 
 * 3. 最后的时候l1和l2中正好有一个是非空的将其添加到融合列表中 
 * 4. 因为融合列表第一个节点的值是-1,所以返回的时候从-1的下一个节点开始返回
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(-1);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode curMerge = headNode;
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                curMerge.next = cur2;
                cur2 = cur2.next;
            }else {
                curMerge.next = cur1;
                cur1 = cur1.next;
            }
            curMerge = curMerge.next;
        }
        //此时l1和l2中正好有一个是非空的，因此将非空列表连接到合并列表的末尾。
        curMerge.next  = cur1 == null ? cur2 : cur1;
        return headNode.next;
    }
}