#
# @lc app=leetcode id=25 lang=python3
#
# [25] Reverse Nodes in k-Group
#
# https://leetcode.com/problems/reverse-nodes-in-k-group/description/
#
# algorithms
# Hard (39.53%)
# Likes:    1732
# Dislikes: 337
# Total Accepted:    236.4K
# Total Submissions: 596.2K
# Testcase Example:  '[1,2,3,4,5]\n2'
#
# Given a linked list, reverse the nodes of a linked list k at a time and
# return its modified list.
# 
# k is a positive integer and is less than or equal to the length of the linked
# list. If the number of nodes is not a multiple of k then left-out nodes in
# the end should remain as it is.
# 
# 
# 
# 
# Example:
# 
# Given this linked list: 1->2->3->4->5
# 
# For k = 2, you should return: 2->1->4->3->5
# 
# For k = 3, you should return: 3->2->1->4->5
# 
# Note:
# 
# 
# Only constant extra memory is allowed.
# You may not alter the values in the list's nodes, only nodes itself may be
# changed.
# 
# 
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head

        prev = dummy
        while prev:
            prev = self.reverse_k(prev,k)

        return dummy.next

    def reverse_k(self, prev: ListNode, k: int) -> ListNode:
        if k <= 0:
            return None
        if prev == None:
            return None
        
        node_1, node_k = prev.next, prev
        head = prev
        for i in range(k):
            if not node_k:
                return None
            node_k = node_k.next
        if not node_k:
            return None
        
        node_kplus = node_k.next
        self.reverse(head, head.next,k)
        node_1.next = node_kplus
        prev.next = node_k

        return node_1
        
    def reverse(self, prev: ListNode, curt: ListNode, k: int):
        for i in range(k):
            temp = curt.next
            curt.next = prev
            prev = curt
            curt = temp


# @lc code=end

