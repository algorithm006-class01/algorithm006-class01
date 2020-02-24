package cn.geet.week1;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月16日 08:42:00
 */
public class LeetCode_21_363 {

    /**
     * Merge two lists list node. 递归方式
     *
     * @param node1
     *            the node 1
     * @param node2
     *            the node 2
     * @return the list node
     */
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (null == node1) {
            return node2;
        } else if (null == node2) {
            return node1;
        } else if ((int)node1.val < (int)node2.val) {
            node1.next = mergeTwoLists(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeTwoLists(node1, node2.next);
            return node2;
        }
    }

    /**
     * Merge two lists 2 list node. 迭代方式
     *
     * @param node1
     *            the node 1
     * @param node2
     *            the node 2
     * @return the list node
     */
    public ListNode mergeTwoLists2(ListNode node1, ListNode node2) {

        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (node1 != null && node2 != null) {
            if ((int)node1.val > (int)node2.val) {
                prev.next = node2;
                node2 = node2.next;
            } else {
                prev.next = node1;
                node1 = node1.next;
            }
            prev = prev.next;
        }

        // 一个节点为空了, 另外一个node直接加在后面
        prev.next = node1 == null ? node2 : node1;
        return prehead.next;
    }

    public static void main(String[] args) {
        LeetCode_21_363 temp = new LeetCode_21_363();

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(5);

        ListNode lastNode = temp.mergeTwoLists(node1, node2);
        while (lastNode != null) {
            System.out.println(lastNode.val);
            lastNode = lastNode.next;
        }
    }
}
