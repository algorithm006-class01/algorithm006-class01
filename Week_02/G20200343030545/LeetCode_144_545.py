"""
    给定一个二叉树，返回它的 前序 遍历。
    示例:
        输入: [1,null,2,3]
           1
            \
             2
            /
           3
    输出: [1,2,3]
    进阶: 递归算法很简单，你可以通过迭代算法完成吗？
"""
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        """
            前序遍历        根左右
        """
        res = []
        self.recursive(root, res)
        return res

    @classmethod
    def recursive(cls, root: TreeNode, res: List) -> None:
        if root:
            res.append(root.val)
            cls.recursive(root.left, res)
            cls.recursive(root.right, res)

    @classmethod
    def use_stack(cls, root: TreeNode) -> List[int]:
        """
            使用栈
            时间复杂度：O(n)，空间复杂度：O(n)
        """
        res = []

        if root:
            stack = [root]

            while stack:
                cur = stack.pop()
                res.append(cur.val)
                if cur.right:  # 先入栈 后弹出
                    stack.append(cur.right)

                if cur.left:
                    stack.append(cur.left)
        return res
