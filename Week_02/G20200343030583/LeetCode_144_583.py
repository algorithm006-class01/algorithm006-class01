#
# @lc app=leetcode id=144 lang=python
#
# [144] Binary Tree Preorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        
        stack, output = [root,],[]
        # stack is not empty, which means which have access all the nodes
        while stack:
            root = stack.pop()
            if root is not None:
                output.append(root.val)
                # remember to check if is None
                if root.right is not None:
                    stack.append(root.right)
                if root.left is not None:
                    stack.append(root.left)
        return output
# @lc code=end

