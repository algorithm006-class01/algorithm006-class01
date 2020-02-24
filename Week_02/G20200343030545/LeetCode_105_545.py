"""
    根据一棵树的前序遍历与中序遍历构造二叉树。
    注意:
        你可以假设树中没有重复的元素。

    例如，给出
        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
        返回如下的二叉树：

            3
           / \
          9  20
            /  \
           15   7
"""
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        """
            先序遍历  根左右
            中序遍历  左根右
        """
        return self.recursive(preorder, inorder)

    @classmethod
    def recursive(cls, preorder: List[int], inorder: List[int]) -> TreeNode:
        """
            时间复杂度：O(n)，空间复杂度：O(n)

        """
        if len(inorder):
            root = TreeNode(preorder[0])

            mid = inorder.index(preorder[0])

            root.left = cls.recursive(preorder[1:mid + 1], inorder[:mid])
            root.right = cls.recursive(preorder[mid + 1:], inorder[mid + 1:])

            return root
