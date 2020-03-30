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


class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        res = 0
        for _ in xrange(32):
            res = (res << 1) + (n & 1)
            n >>= 1
        return res
