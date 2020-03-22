#
# @lc app=leetcode id=144 lang=python3
#
# [144] Binary Tree Preorder Traversal
#
# https://leetcode.com/problems/binary-tree-preorder-traversal/description/
#
# algorithms
# Medium (53.91%)
# Likes:    1197
# Dislikes: 51
# Total Accepted:    436.7K
# Total Submissions: 808.3K
# Testcase Example:  '[1,null,2,3]'
#
# Given a binary tree, return the preorder traversal of its nodes' values.
# 
# Example:
# 
# 
# Input: [1,null,2,3]
# ⁠  1
# ⁠   \
# ⁠    2
# ⁠   /
# ⁠  3
# 
# Output: [1,2,3]
# 
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
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result
        self.dfs(root, result)
        return result

    def dfs(self, node: TreeNode, result: List[int]):
        if not node:
            return 
        result.append(node.val)
        self.dfs(node.left, result)
        self.dfs(node.right, result)

# stack “颜色标记法” 
# https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        stack = [(root, False)]

        while stack:
            node, visited = stack.pop()
            if not node:
                continue
            if visited:
                result.append(node.val)
            else:
                stack.append((node.right, False))
                stack.append((node.left, False))
                stack.append((node, True))
        return result

# @lc code=end

