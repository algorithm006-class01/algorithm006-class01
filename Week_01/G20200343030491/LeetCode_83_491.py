# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        cur1, cur2 = head, head
        while cur2 and cur2.next:
            if cur1.val == cur2.next.val:
                cur2 = cur2.next
            else:
                cur1.next = cur2.next
                cur1, cur2 = cur2.next, cur2.next
        if cur2 and not cur2.next:
            cur1.next = cur2.next
        return head