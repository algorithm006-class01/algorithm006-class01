"""
    给定一个二叉树，判断其是否是一个有效的二叉搜索树。

    假设一个二叉搜索树具有如下特征：

    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
"""


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.recursive(root)

    @classmethod
    def in_order_check(cls, root: TreeNode) -> bool:
        stack = []
        check_value = float("-inf")

        while stack or root:
            while root:
                stack.append(root)
                root = root.left

            node = root.pop()

            if node.val <= check_value:
                return False

            check_value = root.val
            root = root.right

    @classmethod
    def recursive(cls, root: TreeNode, lower=float("-inf"), upper=float("inf")):
        # 递归的终止条件
        if not root:
            return True

        if not (lower < root.val < upper):
            return False

        # 递归下沉
        if not cls.recursive(root.left, lower, root.val):
            return False

        if not cls.recursive(root.right, root.val, upper):
            return False
        # 处理临时状态
        return True
