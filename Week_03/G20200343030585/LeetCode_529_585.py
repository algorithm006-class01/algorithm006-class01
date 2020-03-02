#
# @lc app=leetcode.cn id=529 lang=python
#
# [529] 扫雷游戏
#
# 规则
# 1.M代表为挖出的地雷
# 2.E代表一个未挖出的空方块
# 3.B代表没有相邻地雷的已挖出的空方块
# 4.数字表示有多少已经挖出的有多少地雷与之相邻的方块
# 5。X表示地雷
# 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
# 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
# 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。需要判断四周之后给出
# 如果在此次点击中，若无更多方块可被揭露，则返回面板。
# 
# 解题思路
# 很重要的点就是只是把方块为E的改为B or 数字
# 1.广度优先遍历
#   1.依据点击的位置，向四周辐射
#   2.如果一个地雷被点击，游戏结束, M改为X
#   3.没有相邻地雷空方块挖出改为B，递归周边，E改为B
#   4.如果周边有雷的空方块被挖出，修改E改为1-8，表示雷数，需要判断四周之后给出
#   5.递归结束条件，四周没有多余的方块了

# @lc code=start
# class Solution(object):
#     def updateBoard(self, board, click):
#         (row, col), directions = click, ((-1, 0), (1, 0), (0, 1), (0, -1), (-1, 1), (-1, -1), (1, 1), (1, -1))
#         if 0 <= row < len(board) and 0 <= col < len(board[0]):
#             if board[row][col] == 'M':
#                 board[row][col] = 'X'
#             elif board[row][col] == 'E':
#                 n = sum([board[row + r][col + c] == 'M' for r, c in directions if 0 <= row + r < len(board) and 0 <= col + c < len(board[0])])
#                 board[row][col] = str(n or 'B')
#                 for r, c in directions * (not n): self.updateBoard(board, [row + r, col + c])
#         return board
        
from collections import deque

class Solution(object):
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        R, C = len(board), len(board[0])
        if board[click[0]][click[1]] == "M": 
            board[click[0]][click[1]] = "X"
            return board
        
        dir = [1,0], [0,1], [-1,0],[0,-1],[1,1],[-1,-1],[1,-1],[-1,1]
        q = deque()
        q.append(click)
        seen = set(click)
        
        def numBombsTangent(board, i, j):
            count = 0 
            for x, y in dir: 
                if 0 <= i + x < R and 0 <= j + y < C and board[i+x][y+j] == "M": count += 1 
            return count 

        while q: 
            for tup in range(len(q)):
                x, y = q.popleft()
                if board[x][y] == "E":
                    bombsNextTo = numBombsTangent(board, x, y)
                    board[x][y] = "B" if bombsNextTo == 0 else str(bombsNextTo)
                    if bombsNextTo == 0:
                        for a, b in dir:
                            if 0 <= a + x < R and 0 <= b + y < C and (a+x,b+y) not in seen:
                                q.append((a+x, b+y))
                                seen.add((a+x, b+y))
        return board 
                
                
    
        
    
        
                
# @lc code=end

