# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def mergeTwoLists(l1, l2):
    dummy = ListNode(-1)
    newHead = dummy
    while l1 and l2:
        if l1.val<=l2.val:
            newHead.next = l1
            l1 = l1.next
        else:
            newHead.next = l2
            l2 = l2.next
        newHead = newHead.next
    newHead.next = l1 if l1 is not None else l2
    return dummy.next

def mergeTwoListsRec(l1,l2):
    if not l1 or not l2:
        return l1 or l2
    
    if l1.val <= l2.val:
        l1.next = mergeTwoListsRec(l1.next, l2)
        return l1
    else:
        l2.next = mergeTwoListsRec(l1, l2.next)
        return l2

def mergeTwoListsRecSimple(l1, l2):
    if l1 and l2:
        if l1.val > l2.val:
            l1, l2 = l2, l1
        l1.next = mergeTwoListsRecSimple(l1.next, l2)
    return l1 or l2