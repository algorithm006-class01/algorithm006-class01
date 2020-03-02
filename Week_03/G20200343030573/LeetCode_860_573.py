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


class Solution(object):
    # 不怎么pythonic的写法
    # def lemonadeChange(self, bills):
    #     """
    #     :type bills: List[int]
    #     :rtype: bool
    #     """
    #     if bills[0] > 5:
    #         return False
    #     c5 = 0
    #     c10 = 0
    #     for b in bills:
    #         if b == 5:
    #             c5 += 1
    #             continue
    #         if b == 10:
    #             if c5 >= 1:
    #                 c5 -= 1
    #                 c10 += 1
    #                 continue
    #             return False
    #         if b == 20:
    #             if c5 >= 1 and c10 >= 1:
    #                 c5 -= 1
    #                 c10 -= 1
    #                 continue
    #             elif c10 == 0 and c5 >= 3:
    #                 c5 -= 3
    #                 continue
    #             return False
    #     return True

    # pythonic的写法
    def lemonadeChange(self, bills):
        five = ten = 0
        for i in bills:
            if i == 5:
                five += 1
            elif i == 10:
                five, ten = five - 1, ten + 1
            elif ten > 0:
                five, ten = five - 1, ten - 1
            else:
                five -= 3
            if five < 0: return False
        return True
