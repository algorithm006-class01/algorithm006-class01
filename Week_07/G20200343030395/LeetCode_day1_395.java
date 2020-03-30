package Week_07.G20200343030395;

import java.util.List;

public class LeetCode_day1_395 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};

        ListNode h = new ListNode(0);
        ListNode x = h;

        for (int i=0; i<nums.length; i++) {
            ListNode n = new ListNode(nums[i]);
            h.next = n;
            n.next = null;

            h = n;
        }

        ListNode r = middleNode(x.next);
    }

    public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode h = head;
        if(head == null) {
            return null;
        }

        while(head.next != null){
            count++;
            head = head.next;
        }

        if(count == 0){
            return h;
        }
        count++;

        int x = count/2;

        System.out.println(x);
        while(x > 0) {
            h = h.next;
            x--;
        }

        return h;
    }
}
