#
# @lc app=leetcode id=98 lang=python3
#
# [98] Validate Binary Search Tree
#
# https://leetcode.com/problems/validate-binary-search-tree/description/
#
# algorithms
# Medium (27.06%)
# Likes:    3141
# Dislikes: 447
# Total Accepted:    589.1K
# Total Submissions: 2.2M
# Testcase Example:  '[2,1,3]'
#
# Given a binary tree, determine if it is a valid binary search tree (BST).
# 
# Assume a BST is defined as follows:
# 
# 
# The left subtree of a node contains only nodes with keys less than the node's
# key.
# The right subtree of a node contains only nodes with keys greater than the
# node's key.
# Both the left and right subtrees must also be binary search trees.
# 
# 
# 
# 
# Example 1:
# 
# 
# ⁠   2
# ⁠  / \
# ⁠ 1   3
# 
# Input: [2,1,3]
# Output: true
# 
# 
# Example 2:
# 
# 
# ⁠   5
# ⁠  / \
# ⁠ 1   4
# / \
# 3   6
# 
# Input: [5,1,4,null,null,3,6]
# Output: false
# Explanation: The root node's value is 5 but its right child's value is 4.
# 
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import sys
# divide & conquer
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        valid, max_node, min_node = self.validate_bst(root)
        return valid
    def validate_bst(self, node: TreeNode):
        if not node:
            return (True, None, None)
        
        left_valid, left_max, left_min = self.validate_bst(node.left)
        right_valid, right_max, right_min = self.validate_bst(node.right)

        if not left_valid or not right_valid:
            return (False, None, None)
        if left_max and left_max.val >= node.val:
            return (False, None, None)
        if right_max and right_min.val <= node.val:
            return (False, None, None)

        min_node = left_min if left_min is not None else node
        max_node = right_max if right_max is not None else node

        return (True, max_node, min_node)

# inorder 上升序列
class Solution:
    last_val = -sys.maxsize
    is_valid = True
    def isValidBST(self, root: TreeNode) -> bool:
        self.dfs(root)
        return self.is_valid
    def dfs(self, node: TreeNode):
        if not node or not self.is_valid:
            return
        self.dfs(node.left)
        if node.val <= self.last_val:
            self.is_valid = False
        self.last_val = node.val
        self.dfs(node.right)

# @lc code=end

