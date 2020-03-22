#
# @lc app=leetcode id=94 lang=python3
#
# [94] Binary Tree Inorder Traversal
#
# https://leetcode.com/problems/binary-tree-inorder-traversal/description/
#
# algorithms
# Medium (60.71%)
# Likes:    2512
# Dislikes: 105
# Total Accepted:    634.4K
# Total Submissions: 1M
# Testcase Example:  '[1,null,2,3]'
#
# Given a binary tree, return the inorder traversal of its nodes' values.
# 
# Example:
# 
# 
# Input: [1,null,2,3]
# ⁠  1
# ⁠   \
# ⁠    2
# ⁠   /
# ⁠  3
# 
# Output: [1,3,2]
# 
# Follow up: Recursive solution is trivial, could you do it iteratively?
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# recursion
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result
        self.dfs(root, result)
        return result
        
    def dfs(self, node: TreeNode, result: List[int]):
        if not node:
            return
        self.dfs(node.left, result)
        result.append(node.val)
        self.dfs(node.right, result)

# stack 颜色标记法
# https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result 
        
        stack = [(root, False)]
        while stack:
            node, visited = stack.pop()
            if not node:
                continue
            if visited:
                result.append(node.val)
            else:
                stack.append((node.right, False))
                stack.append((node, True))
                stack.append((node.left, False))

        return result

# @lc code=end

