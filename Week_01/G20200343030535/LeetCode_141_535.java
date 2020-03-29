package leetcode.Week01;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_141_535 {

    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 思路1：暴力法      时间复杂度o(n),空间复杂度o(n)
     * 记录下来你访问过的所有节点，把它记录到set/hash里面
     * 那么，再新访问的元素有没有之前出现在set/hash里面，
     * 表示我又走回到了原来的老节点去了，
     * 那就说明有环了
     * 思路2：快慢指针     时间复杂度o(n),空间复杂度o(1)
     *
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null){
            if (nodesSeen.contains(head)){
                return true;
            }else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            /**分成2种情况：
             * 1.快指针是尾节点的情况，则判断fast.next=null
             * 2.快指针走2步就是空指针的情况，则判断fast=null
             *   */
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            /**快指针每次走2步*/
            fast = fast.next.next;
        }
        return true;
    }


}
