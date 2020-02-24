public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //本题没有多大技巧，无非就是利用几个o（1）的变量进行相互转换
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode merge;
        if (l1.val < l2.val) {
            merge = l1;
            l1 = l1.next;
        } else {
            merge = l2;
            l2 = l2.next;
        }
        ListNode index = merge;
        while (l1 != null && l2 != null) {
            ListNode max;
            if (l1.val < l2.val) {
                max = l1;
                l1 = l1.next;
            } else {
                max = l2;
                l2 = l2.next;
            }
            index.next = max;
            index = max;
        }
        if (l1 != null) {
            index.next = l1;
        }
        if (l2 != null) {
            index.next = l2;
        }
        return merge;
    }
