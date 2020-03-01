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

"""

"""
思路：
    这周主要练习递归，所以迭代的方法后续再补上
    对于N 叉树， 不仅有左子树与右子树
    而且是 child1,child2,child3,....childN
    于后序而言
    先走访 (由左至右) 所有的儿子
    最后访问根结点
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if root:
            res = []
            res.append(root.val)
            res.extend(self.preorderTraversal(root.left))
            res.extend(self.preorderTraversal(root.right))

        else:
            res = []
        return res
