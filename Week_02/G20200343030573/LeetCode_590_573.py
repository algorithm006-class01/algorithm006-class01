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

    # 方法一 递归遍历所有的子节点 最后再添加当前根节点的值
    # 当然如果是前序遍历就先添加当前根节点的值再遍历子节点
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []
        if root is None:
            return res

        def recursive(root, res):
            for c in root.children:
                recursive(c, res)
            res.append(root.val)  # 如果是前序遍历就放到for循环上面

        recursive(root, res)
        return res

    # 方法二 利用栈，以后序遍历的顺序将各个节点入栈，然后逐个出栈记录val，最后倒序 时间复杂度应该是O(1)
    def _postorder(self, root):
        res = []
        if root is None:
            return res
        stack = [root]
        while stack:
            cur = stack.pop()
            res.append(cur.val)
            stack.extend(cur.children)
        return res[::-1]
