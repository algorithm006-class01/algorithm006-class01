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
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        # 方法一
        # m = 0
        # for i, n in enumerate(nums):
        #     if i > m:
        #         return False
        #     m = max(m, i + n)
        # return True

        # 贪心算法？
        def canJump(self, nums):
            goal = len(nums) - 1
            for i in range(len(nums))[::-1]:
                if i + nums[i] >= goal:
                    goal = i
            return not goal
