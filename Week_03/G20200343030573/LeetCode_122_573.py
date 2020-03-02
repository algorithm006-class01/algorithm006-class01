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
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # 这道题的难点好像并不是算法 熟悉递增数列是关键点更合适点
        # 只要子序列是递增的那么依次增加之和即该子序列的最大值减最小值
        return sum([
            prices[i + 1] - prices[i] for i in range(len(prices) - 1) if prices[i + 1] > prices[i]
        ])
