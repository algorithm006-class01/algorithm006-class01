"""
    给定一个 N 叉树，返回其节点值的后序遍历。
    说明: 递归法很简单，你可以使用迭代法完成此题吗?
"""

from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: Node) -> List[int]:
        """左右根"""
        # return self.use_stack_and_reverse(root)
        res = []
        self.recursive(root, res)
        return res

    @classmethod
    def recursive(cls, root: Node, res: List[int]):
        """
            递归的写法
        """
        if root:
            for child in root.children:
                cls.recursive(child, res)
            res.append(root.val)

    @classmethod
    def use_stack_and_reverse(cls, root: Node) -> List[int]:
        """
            循环实现。
            后序遍历是左右根，可以先输入为根右左 然后反转一下就是左右根
            时间复杂度O(n)，空间复杂度O(n)
        """

        res = []
        if root:

            stack = [root]
            while stack:
                cur = stack.pop()
                res.append(cur.val)

                for child in cur.children:
                    stack.append(child)
        return res[::-1]
