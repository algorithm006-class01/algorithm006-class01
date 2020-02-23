#!/usr/bin/env python
# -*- coding:utf-8 -*-

import sys

__author__ = "Onceabu"
__version__ = "v2.0"

"""
    Time      
    describe  
    copyright (c) 2019 by Abu
"""

reload(sys)
sys.setdefaultencoding('utf-8')

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution(object):
    # 方法一：正常思路 遍历每一层的同时记录每个节点的子节点 循环
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        res = []
        if root is None:
            return res

        nodes = [root]
        while nodes:
            childrens = []
            res.append([])
            for n in nodes:
                res[-1].append(n.val)
                if n.children:
                    childrens.extend(n.children)
                nodes = childrens
        return res

    # 方法二 递归 待研究
