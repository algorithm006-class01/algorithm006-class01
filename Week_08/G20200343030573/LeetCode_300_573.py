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
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # dp
        if not nums:
            return 0
        dp = []
        for i, n in enumerate(nums):
            dp.append(1)
            for j in range(i):
                if n > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        print max(dp)

        # 贪心+二分法
        cur = []
        for n in nums:
            if not cur or n > cur[-1]:
                cur.append(n)
            else:
                l, r = 0, len(cur) - 1
                loc = -1
                while l <= r:
                    mid = (l + r) // 2
                    if cur[mid] >= n:
                        loc = mid
                        r = mid - 1
                    else:
                        l = mid + 1
                cur[loc] = n
        return len(cur)
