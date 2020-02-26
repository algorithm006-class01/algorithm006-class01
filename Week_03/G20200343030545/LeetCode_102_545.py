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
    def DFS_BY_RECURSIVE(cls, node: TreeNode, level: int, res: List[List[int]]):
        """
            深度优先 一条线走到低，然后从底开始回溯  递归的解法
        """
        if level == len(res):
            res.append([])
        res[level].append(node.val)

        if node.left:
            cls.DFS_BY_RECURSIVE(node.left, level + 1, res)

        if node.right:
            cls.DFS_BY_RECURSIVE(node.right, level + 1, res)

    @classmethod
    def DFS_BY_STACK(cls, node: TreeNode) -> List[List[int]]:
        """
            深度优先 自己维护一个栈来操作
        """
        pass

    @classmethod
    def BFS(cls, root: TreeNode):
        """
            广度优先  一层一层访问

        """
        res = []
        if root:
            queue = [root]

            while queue:
                next_nodes = []  # 存放下一层的所有节点
                res.append([])
                for node in queue:
                    if node.left:
                        next_nodes.append(node.left)
                    if node.right:
                        next_nodes.append(node.right)
                    res[-1].append(node.val)
                queue = next_nodes
        return res
