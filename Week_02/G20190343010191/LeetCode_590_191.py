"""
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

返回其后序遍历: [5,6,3,2,4,1].
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

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def postorder(self, root: 'Node') -> list[int]:
        if root:
            res = []
            for child in root.children:
                res.extend(self.postorder(child))
            res.append(root.val)
        else:
            res = []
        return res
