const mergeTwoLists = function(l1, l2) {
  const prevHead = new ListNode(-1);
  let prevNode = prevHead;
  while (l1 !== null && l2 !== null) {
    if (l1.val < l2.val) {
      prevNode.next = l1;
      l1 = l1.next;
    } else {
      prevNode.next = l2;
      l2 = l2.next;
    }
    prevNode = prevNode.next;
  }
  prevNode.next = l1 || l2;
  return prevHead.next;
};
