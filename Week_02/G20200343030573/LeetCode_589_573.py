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
    # 方法一：同590 把res.append放到for循环之前即可
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []
        if root is None:
            return res

        def recursive(root, res):
            res.append(root.val)
            for c in root.children:
                recursive(c, res)

        recursive(root, res)
        return res

    # 方法二：同590一样也是用栈 只是这里要注意后序是刚好顺序相反可以直接反转
    # 但是前序的话root顺序是对的，children顺序是反的，所以只需要反转children即可
    def _preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []
        if root is None:
            return res

        stack = [root]
        while stack:
            cur = stack.pop()
            res.append(cur.val)
            stack.extend(cur.children[::-1])
        return res
