/*
 * 21. Merge Two Sorted Lists
 * 合并两个有序链表
 */
public class LeetCode_21_569 {

	public static void main(String[] args) {
		LeetCode_21_569 lc = new LeetCode_21_569();
		ListNode ln13 = lc.createNewNode(4, null);
		ListNode ln12 = lc.createNewNode(2, ln13);
		ListNode ln11 = lc.createNewNode(1, ln12);
		
		ListNode ln23 = lc.createNewNode(4, null);
		ListNode ln22 = lc.createNewNode(3, ln23);
		ListNode ln21 = lc.createNewNode(1, ln22);
		
		ListNode node = lc.new Solution().mergeTwoLists(ln11,ln21);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		
	}
	
	public ListNode createNewNode( int i, ListNode next ) {
		ListNode node = new ListNode(i);
		node.next = next;
		return node;
	}
	
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	class Solution {
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    	ListNode tempNode = new ListNode(0);
	    	ListNode currentNode = tempNode;
	    	while (l1 != null && l2 != null) {
	    		currentNode.next = (l1.val < l2.val) ? l1 : l2;
	    		ListNode n = (l1.val < l2.val) ? (l1 = l1.next) : (l2 = l2.next);
	    		currentNode = currentNode.next;
	    	}
	    	ListNode nonEmpty = (l1 != null) ? l1 : l2;
	    	currentNode.next = nonEmpty;	    		
	        return tempNode.next;
	    }
	}
}
