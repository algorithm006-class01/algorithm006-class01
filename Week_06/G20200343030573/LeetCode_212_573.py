#!/usr/bin/env python
# -*- coding:utf-8 -*-
import sys
from collections import defaultdict

__author__ = "Onceabu"
__version__ = "v1.0"

"""
    Time      
    describe  
"""

reload(sys)
sys.setdefaultencoding('utf-8')

# words = ["oath","pea","eat","rain"]
# board = [
#     ['o', 'a', 'a', 'n'],
#     ['e', 't', 'a', 'e'],
#     ['i', 'h', 'k', 'r'],
#     ['i', 'f', 'l', 'v']
# ]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
END_OF_WORD = '#'


class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        if not board or not board[0]:
            return []
        if not words:
            return []

        self.result = set()

        # O(N*k) N是words的长度 k是单词平均长度
        # 构建Trie树
        root = defaultdict()
        for word in words:
            node = root
            for char in word:
                # 返回子节点
                node = node.setdefault(char, defaultdict())
            node[END_OF_WORD] = END_OF_WORD

        # O(m*n*N*k)
        self.m, self.n = len(board), len(board[0])
        for i in xrange(self.m):
            for j in xrange(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, '', root)
        return list(self.result)

    # O(N*k)
    def _dfs(self, board, i, j, cur_word, cur_dict):
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]
        if END_OF_WORD in cur_dict:
            self.result.add(cur_word)
        tmp, board[i][j] = board[i][j], '@'
        for k in xrange(4):
            x, y = i + dx[k], j + dy[k]
            if 0 <= x < self.m and 0 <= y < self.n and board[x][y] != '@' and board[x][y] in cur_dict:
                self._dfs(board, x, y, cur_word, cur_dict)
        board[i][j] = tmp

# 完整的时间复杂度是 O(N*k)+O(m*n*N*k)
# 最终的时间复杂度就是 O(m*n*N*k) N是words的长度 k是单词平均长度 m是board的行数 n是列数
