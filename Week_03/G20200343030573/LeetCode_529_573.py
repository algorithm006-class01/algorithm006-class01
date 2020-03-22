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
    # 有待进一步研究
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        if not board or not board[0]:
            return []
        i, j = click[0], click[1]
        if board[i][j] == "M":
            board[i][j] = "X"
            return board
        m, n = len(board), len(board[0])
        directions = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
        self.dfs(i, j, m, n, board, directions)
        return board

    def dfs(self, i, j, m, n, board, directions):
        if board[i][j] != "E":
            return
        mine_count = 0
        for d in directions:
            di, dj = i + d[0], j + d[1]
            if 0 <= di < m and 0 <= dj < n and board[di][dj] == "M":
                mine_count += 1
        if mine_count == 0:
            board[i][j] = "B"
        else:
            board[i][j] = str(mine_count)
            return
        for d in directions:
            di, dj = i + d[0], j + d[1]
            if 0 <= di < m and 0 <= dj < n:
                self.dfs(di, dj, m, n, board, directions)
