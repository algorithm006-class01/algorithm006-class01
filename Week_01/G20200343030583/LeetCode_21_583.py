#
# @lc app=leetcode id=21 lang=python
#
# [21] Merge Two Sorted Lists
# 1. iteratively
# 2. recursively

# @lc code=start
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# First
# class Solution(object):
#     def mergeTwoLists(self, l1, l2):
#         """
#         :type l1: ListNode
#         :type l2: ListNode
#         :rtype: ListNode
#         """
#         # No head point
#         # because it may not go into the first loop
#         current = l = ListNode(0)
#         p = l1
#         q = l2
    
#         while p and q:
#             if p.val < q.val:
#                 current.next = p
#                 p = p.next
#             else:
#                 current.next = q
#                 q = q.next
#             current = current.next
#         if q:
#             current.next = q
#         if p:
#             current.next = p
#         return l.next

# Second
def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if not l1:
            return l2
        if not l2:
            return l1
        
        start = None
        if l1.val < l2.val:
            start = l1
            start.next = self.mergeTwoLists(l1.next,l2)
        else:
            start = l2
            start.next = self.mergeTwoLists(l1, l2.next)
        
        return start

# @lc code=end

