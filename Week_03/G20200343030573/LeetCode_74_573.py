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
    # 同样是借助二分法
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if matrix:
            n = len(matrix[0])
            lo, hi = 0, len(matrix) * n
            while lo < hi:
                mid = (lo + hi) / 2
                x = matrix[mid / n][mid % n]
                if x < target:
                    lo = mid + 1
                elif x > target:
                    hi = mid
                else:
                    return True
        return False
