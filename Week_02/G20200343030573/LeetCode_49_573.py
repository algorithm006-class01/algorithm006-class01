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
    # 主要是借助dict 即哈希表
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        res = {}
        for s in strs:
            k = ''.join(sorted(s))
            res[k] = res.get(k, []) + [s]  # pythonic
        # return res.values()
        return list(res.values())  # python3的话需要转一下
