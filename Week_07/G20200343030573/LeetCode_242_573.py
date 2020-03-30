#!/usr/bin/env python
# -*- coding:utf-8 -*-
import string
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
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        return all([s.count(c) == t.count(c) for c in string.ascii_lowercase])
