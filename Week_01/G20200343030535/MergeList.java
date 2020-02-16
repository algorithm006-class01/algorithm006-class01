package leetcode;



public class MergeList {

    /**
     * 题目：
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null){return l2;}
        if (l2 == null && l1 != null){return l1;}
        /**这里使用pre和preHead来指向同一个内存空间，一个方便遍历并修改，一个方便获取所有的节点*/
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        ListNode listNode = mergeTwoLists(node1,node4);
        ListNode listNode1 = listNode;
        while (listNode1.next != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
        System.out.println(listNode1.val);
    }

}
