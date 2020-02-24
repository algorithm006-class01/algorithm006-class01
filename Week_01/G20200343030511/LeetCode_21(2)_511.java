/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode prehead = new ListNode(-1);

	        ListNode prev = prehead;
	        //考虑一点，只要有一个为空，其他的就不需要迭代了。。
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
	        prev.next = l1 == null ? l2 : l1;
	        return prehead.next;
	    }
}