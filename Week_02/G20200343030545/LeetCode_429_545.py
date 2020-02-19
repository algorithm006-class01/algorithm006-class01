"""
    给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

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

from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: Node) -> List[List[int]]:
        return self.use_queue(root)

    @classmethod
    def recursive(cls, root: Node) -> List[List[int]]:
        """
            递归
            时间复杂度 O(n)
            空间复杂度 O(n)
        """

        def hand(node: Node, level) -> None:
            if len(res) == level:
                res.append([])
            res[level].append(node.val)

            for child in node.children:
                hand(child, level + 1)

        res = []
        if root:
            hand(root, 0)

        return res

    @classmethod
    def use_queue(cls, root: Node) -> List[List[int]]:
        """
            使用queue保存当前层的节点。
            时间复杂度是 O(nk) k为节点最多一层的数目，因为extend的时间复杂度是O(k)
            空间复杂度是 O(n)
        """
        res = []
        if root:
            queue = [root]
            while queue:
                tmp_queue = []
                tmp_res = []

                for node in queue:  # 每一次的循环都是一层
                    if node:
                        tmp_res.append(node.val)
                        tmp_queue.extend(node.children)
                queue = tmp_queue
                res.append(tmp_res)
        return res
