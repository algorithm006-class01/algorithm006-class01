public ListNode reverseList(ListNode head) {
        ListNode newhead = head;
        ListNode newhead2 = head;
        Stack<Integer> stack = new Stack<>();

        while (newhead != null) {
            stack.push(newhead.val);
            newhead = newhead.next;
        }
        
        while(newhead2 != null) {
            newhead2.val = stack.pop();
            newhead2 = newhead2.next;
        }
        return head;
    }
