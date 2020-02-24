public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        if (head == null) return false;
            ListNode fast = head.next;
            while (fast != slow) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
    }
