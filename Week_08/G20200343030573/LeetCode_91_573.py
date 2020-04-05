#!/usr/bin/env python
# -*- coding:utf-8 -*-

import sys

__author__ = "Onceabu"
__version__ = "v1.0"

"""
    Time      
    describe  
"""

reload(sys)
sys.setdefaultencoding('utf-8')

'''
关于第91题的个人思考
91题题目交代的不清楚，通过解答才明确相关的信息：

"1001"或"0101"是不能解析为1 1的
同时像"130"也是不能解析的

也就是说0是不能忽略的，这样的话问题难度就降低了很多
但是如果0可以忽略，这题目有没有合适的解法呢？
值得思考
'''


class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s[0] == '0':
            return 0
        a = b = 1
        for i in range(1, len(s)):
            tmp = b
            if s[i] == '0':
                if s[i - 1] not in ['1', '2']:
                    return 0
                b = a
            elif s[i - 1] == '1' or (s[i - 1] == '2' and '1' <= s[i] <= '6'):
                b = a + b
            a = tmp
        return b


'''
复习斐波那契
空间复杂度最低 但是如果需要保留所有的记录就需要一个dp列表记录保存
def feb(n):
    if n <= 1:
        return n
    a, b = 0, 1
    for i in range(1, n):
        a, b = b, a + b
    return b


def feb(n):
    if n <= 1:
        return n
    return feb(n - 1) + feb(n - 2)
'''
