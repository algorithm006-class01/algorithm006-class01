"""
给定一个 N 叉树，返回其节点值的前序遍历。
"""
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: Node) -> List[int]:
        res = []
        self.recursive(root, res)
        return res

    @classmethod
    def loop(cls, root: Node) -> List[int]:
        """
            前序遍历 根左右
            迭代写法
            时间复杂度：O(n)，空间复杂度：O(n)
        """
        res = []
        if root:
            stack = [root]
            while stack:
                node = stack.pop()
                res.append(node.val)
                for node in reversed(node.children):  # 反转
                    stack.append(node)

        return res

    @classmethod
    def recursive(cls, root: Node, res: List[int]):
        """
            递归写法
            时间复杂度: O(n)，空间复杂度:O(n)
        """
        if root:
            res.append(root.val)
            for child in root.children:
                cls.recursive(child, res)
