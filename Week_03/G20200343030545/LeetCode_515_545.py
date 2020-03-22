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
            # res = []
            # self.DFS(root, 0, res)

    @classmethod
    def DFS(cls, root: TreeNode, index: int, res: List[List[int]]):
        if index == len(res):
            res.append([])
        res[index].append(root.val)

        if root.left:
            cls.DFS(root.left, index + 1, res)

        if root.right:
            cls.DFS(root.right, index + 1, res)

    @classmethod
    def BFS(cls, root: TreeNode) -> List[int]:

        res = []
        queue = [root]
        while queue:
            new_queue = []
            max_res = float("-inf")
            for node in queue:
                if node.left:
                    new_queue.append(node.left)
                if node.right:
                    new_queue.append(node.right)
                max_res = max(max_res, node.val)
            res.append(max_res)

            queue = new_queue
        return res
