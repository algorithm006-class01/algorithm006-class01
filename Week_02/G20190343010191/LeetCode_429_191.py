"""
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

 



 

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
 

说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。

"""

"""
思路：
    一样先练习递归
    与前几题相同
    主要加上层数处理
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> list[list[int]]:

        def recur_deph(root: 'Node', depth, res_list):

            if depth + 1 > len(res_list):
                res_list.append([])
            res_list[depth].append(root.val)

            for child in root.children:
                if child:
                    recur_deph(child, depth + 1, res_list)
            return res_list

        if root:
            res = []
            res = recur_deph(root, 0, res)

        else:
            res = []
        return res
