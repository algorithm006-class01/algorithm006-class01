#
# @lc app=leetcode id=114 lang=python3
#
# [114] Flatten Binary Tree to Linked List
#
# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
#
# algorithms
# Medium (46.32%)
# Likes:    2215
# Dislikes: 275
# Total Accepted:    303.7K
# Total Submissions: 652.5K
# Testcase Example:  '[1,2,5,3,4,null,6]'
#
# Given a binary tree, flatten it to a linked list in-place.
# 
# For example, given the following tree:
# 
# 
# ⁠   1
# ⁠  / \
# ⁠ 2   5
# ⁠/ \   \
# 3   4   6
# 
# 
# The flattened tree should look like:
# 
# 
# 1
# ⁠\
# ⁠ 2
# ⁠  \
# ⁠   3
# ⁠    \
# ⁠     4
# ⁠      \
# ⁠       5
# ⁠        \
# ⁠         6
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

# divide & conquer
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.flatten_subtree(root)
        
    def flatten_subtree(self, node: TreeNode) -> TreeNode:
        if not node:
            return None
        
        left_last = self.flatten_subtree(node.left)
        right_last = self.flatten_subtree(node.right)

        if left_last:
            left_last.right = node.right
            node.right = node.left
            node.left = None
        
        if right_last:
            return right_last
        if left_last:
            return left_last
        return node

# traversal
class Solution:
    last_node = None
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return

        if self.last_node:
            self.last_node.right = root
            self.last_node.left = None
        
        self.last_node = root
        right = root.right
        self.flatten(root.left)
        self.flatten(right)

# @lc code=end

