package G20200343030391;

public class LeetCode_21_391 {

    public static void main(String[] args) {

        // 1->2->4
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l14 = new ListNode(4);
        l11.next = l12;
        l12.next = l14;
        // 1->3->4
        ListNode l21 = new ListNode(1);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(4);
        l21.next = l23;
        l23.next = l24;

        ListNode listNode = mergeTwoLists_2(l11, l21);
        System.out.println(listNode);
    }

    /**
     * 解法1：allNode为合并后的结果，currentNode连接l1和l2的最小的next节点
     * 时间复杂度：O(n)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        ListNode allNode = new ListNode(-1);

        ListNode currentNode = allNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = l1 == null ? l2 : l1;

        return allNode.next;

    }
    /**
     * 解法2：递归查找
     * 时间复杂度：O(n)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists_2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_2(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        @Override
        public String toString() {
            String toString = this.val + "->";
            ListNode next = this.next;
            while (next != null) {
                toString = toString + next.val + "->";
                next = next.next;
            }
            return toString + "null";
        }
    }
}
