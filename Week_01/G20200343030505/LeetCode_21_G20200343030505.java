/**
 * 
 */

/**
 * @author huangwen05
 *
 * @date:   2020年2月16日 下午8:49:22 
 */
public class LeetCode_21_G20200343030505 {
	   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

	        ListNode cur = new ListNode(0);
	        ListNode head = cur;
	        while (l1 != null && l2 != null) {
	            if(l1.val < l2.val) {
	                cur.next = l1;
	                cur = l1;
	                l1 = l1.next;
	            } else {
	                cur.next = l2;
	                cur = l2;
	                l2 = l2.next;
	            }
	        }


	        if(l1 == null) {
	            cur.next = l2;
	        }    

	        if(l2 == null) {
	            cur.next = l1;
	        }

	        return head.next;
	       
	    }
	}