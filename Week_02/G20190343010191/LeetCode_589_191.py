"""
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

返回其前序遍历: [1,3,5,6,2,4]。
"""

"""
思路：
    
    对于N 叉树， 不仅有左子树与右子树
    而且是 child1,child2,child3,....childN
    于后序而言
    先访问根结点
    最后走访 (由左至右) 所有的儿子
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def preorder(self, root: 'Node') -> list[int]:
        if root:
            res = []
            res.append(root.val)
            for child in root.children:
                res.extend(self.preorder(child))

        else:
            res = []
        return res
