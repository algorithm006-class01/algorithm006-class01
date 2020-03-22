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

# 复习斐波那契
# def feb(n):
#     if n <= 1:
#         return n
#     a, b = 0, 1
#     for i in range(1, n):
#         a, b = b, a + b
#     return b


# def feb(n):
#     if n <= 1:
#         return n
#     return feb(n - 1) + feb(n - 2)
#
#
# if __name__ == '__main__':
#     for i in range(10):
#         print feb(i)
