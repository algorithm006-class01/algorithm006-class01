var mergeTwoLists = function(l1, l2) {
    let dummy = new ListNode(0);
    let p = dummy;
    let p1 = l1, p2 = l2;
    while (p1 && p2) {
        if (p1.val < p2.val) {
            p.next = p1;
            p1 = p1.next;
        } else {
            p.next = p2;
            p2 = p2.next;
        }
        p = p.next;
    }
    p.next = p1 ? p1 : p2 ? p2 : null;
    return dummy.next;
}
