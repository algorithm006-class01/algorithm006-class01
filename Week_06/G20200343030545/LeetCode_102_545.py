"""
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
"""
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        """
        二叉树的层次遍历
        """
        return self.dfs(root)

    @classmethod
    def bfs(cls, root: TreeNode) -> List[List[int]]:
        """
            广度优先
        """
        queue = [root]
        res = []
        while queue:
            tmp_res = []
            tmp_queue = []
            for node in queue:
                if node:
                    tmp_res.append(node.val)
                    if node.left:
                        tmp_queue.append(node.left)
                    if node.right:
                        tmp_queue.append(node.right)
            queue = tmp_queue
            if tmp_res:
                res.append(tmp_res)
        return res

    @classmethod
    def dfs(cls, root: TreeNode) -> List[List[int]]:

        def helper(node: TreeNode, level: int):
            if node:
                if level == len(res):
                    res.append([])
                res[level].append(node.val)

                if node.left:
                    helper(node.left, level + 1)
                if node.right:
                    helper(node.right, level + 1)

        res = []
        helper(root, 0)
        return res
