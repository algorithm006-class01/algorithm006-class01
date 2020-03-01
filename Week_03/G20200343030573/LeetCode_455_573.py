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
    # 这个算是叫贪心算法吗
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()
        childi = 0
        gl = len(g)
        for _s in s:
            if childi < gl and _s >= g[childi]:
                childi += 1
        return childi
