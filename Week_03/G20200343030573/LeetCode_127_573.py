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

from collections import deque


# 这个广度优先是在建立了字典索引的基础上？
# 有待进一步研究
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):

        def construct_dict(word_list):
            d = {}
            for word in word_list:
                for i in range(len(word)):
                    s = word[:i] + "_" + word[i + 1:]
                    d[s] = d.get(s, []) + [word]
            return d

        def bfs_words(begin, end, dict_words):
            queue, visited = deque([(begin, 1)]), set()
            while queue:
                word, steps = queue.popleft()
                if word not in visited:
                    visited.add(word)
                    if word == end:
                        return steps
                    for i in range(len(word)):
                        s = word[:i] + "_" + word[i + 1:]
                        neigh_words = dict_words.get(s, [])
                        for neigh in neigh_words:
                            if neigh not in visited:
                                queue.append((neigh, steps + 1))
            return 0

        d = construct_dict(wordList)
        return bfs_words(beginWord, endWord, d)
