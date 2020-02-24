#
# @lc app=leetcode.cn id=104 lang=python
#
# [104] 二叉树的最大深度
#

# @lc code=start
# 解题思路
# 1、递归 递归几次就是最大深度，去掉最后可能为空的情况
# 2、循环 不断循环子节点，每次加一

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        def depth(node, level):
            if not node:
                return level

            l_val = r_val = 0

            if node.left:
                l_val = depth(node.left, level + 1)
            if node.right:
                r_val = depth(node.right, level + 1)
            return max(l_val, r_val, level)
        
        return depth(root, 1)

            
# @lc code=end

