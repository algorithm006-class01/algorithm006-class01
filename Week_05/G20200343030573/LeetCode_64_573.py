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
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # row行
        # col列
        row, col = len(grid), len(grid[0])
        dp = [0] + [sys.maxint] * (col - 1)
        for r in range(row):
            dp[0] = dp[0] + grid[r][0]
            for c in range(1, col):
                dp[c] = min(dp[c - 1], dp[c]) + grid[r][c]
        return dp[-1]
