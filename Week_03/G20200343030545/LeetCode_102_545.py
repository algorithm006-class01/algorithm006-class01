"""
    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

    例如:
        给定二叉树: [3,9,20,null,null,15,7],
"""

from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if root:
            self.DFS(root, 0, res)

        return res

    @classmethod
    def DFS(cls, node: TreeNode, level: int, res: List[List[int]]):
        """
            深度优先 一条线走到低，然后从底开始回溯  递归的解法
        """
        # terminator
        if level == len(res):
            res.append([])
        res[level].append(node.val)

        if node.left:
            cls.DFS(node.left, level + 1, res)
        if node.right:
            cls.DFS(node.right, level + 1, res)

    @classmethod
    def BFS(cls, root: TreeNode) -> List[List[int]]:
        """
            广度优先  一层一层访问
        """
        res = []

        if res:
            queue = [root]
            while queue:
                new_queue = []
                tmp_res = []
                for node in queue:
                    if node.left:
                        new_queue.append(node.left)
                    if node.right:
                        new_queue.append(node.right)
                    tmp_res.append(node.val)

                new_queue.append(tmp_res)
                queue = new_queue
        return res
