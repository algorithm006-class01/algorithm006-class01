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


class Trie(object):

    def __init__(self):
        self.set1 = set()
        self.set2 = set()

    def insert(self, word):
        self.set1.add(word)
        for i in range(len(word)):
            self.set2.add(word[:i + 1])

    def search(self, word):
        if word in self.set1:
            return True
        else:
            return False

    def startsWith(self, prefix):
        if prefix in self.set2:
            return True
        else:
            return False
