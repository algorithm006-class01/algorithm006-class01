#解题思路
# 1. 递归方法，逐级递归, 其中重复的部分是找子层级里面的每个元素


# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        
        res = [[root.val]]
        self._levelOrder(root.children, res)
        return res

    def _levelOrder(self, children, res=[]):
        if len(children) == 0:
            return

        ret = []
        self_children = []
        length = len(children)
        for i in range(length):
            self_children += children[i].children
            ret.append(children[i].val)
            
        res.append(ret)
        self._levelOrder(self_children, res)


        