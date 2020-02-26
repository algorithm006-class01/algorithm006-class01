"""
    您需要在二叉树的每一行中找到最大的值。

    示例：

        输入:

                  1
                 / \
                3   2
               / \   \
              5   3   9

        输出: [1, 3, 9]
"""
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root:
            # return self.BFS(root)
            res = []
            self.DFS(root, 0, res)
            return [max(i) for i in res]

    @classmethod
    def DFS(cls, root: TreeNode, level: int, res: List[List[int]]):
        if level == len(res):
            res.append([])
        res[level].append(root.val)

        if root.left:
            cls.DFS(root.left, level + 1, res)
        if root.right:
            cls.DFS(root.right, level + 1, res)

    def BFS(self, root: TreeNode) -> List[int]:
        res = []

        queue = [root]

        while queue:
            nodes = []
            max_res = float("-inf")
            for node in queue:
                if node.left:
                    nodes.append(node.left)
                if node.right:
                    nodes.append(node.right)
                max_res = max(max_res, node.val)
            res.append(max_res)
            queue = nodes
        return res
