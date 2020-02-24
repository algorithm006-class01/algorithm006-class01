"""
    给定一个二叉树，返回它的中序 遍历。
    示例:
        输入: [1,null,2,3]
           1
            \
             2
            /
           3

        输出: [1,3,2]
    进阶: 递归算法很简单，你可以通过迭代算法完成吗？
"""
from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        """中序遍历左根右"""
        res = []
        self.recursive(root, res)
        return res

    @classmethod
    def recursive(cls, root: TreeNode, res: List) -> None:
        """
            递归解法  固定套路 记住就行
            时间复杂度：O(n)，空间复杂度：O(logn)

        """
        if root:
            cls.recursive(root.left, res)
            res.append(root.val)
            cls.recursive(root.right, res)

    @classmethod
    def use_stack(cls, root: TreeNode, res: List) -> List[int]:
        """
            使用栈
            遍历树，判断树是否有左子树，如果有，就依次压入栈中。
            没有就从栈顶弹出节点，并且把节点的值输出到结果集里面。然后判断这个节点是否有右子树。
            时间复杂度:O(n)，空间复杂度：O(n)
        """
        stack = []
        res = []

        cur = root

        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right
        return res
