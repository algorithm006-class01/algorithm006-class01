#
# @lc app=leetcode id=529 lang=python
#
# [529] Minesweeper
# use dfs  O(row*col)

# @lc code=start
class Solution(object):
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        if not board:
            return []
        i,j  = click[0],click[1]
        if board[i][j] == 'M':
            board[i][j] = 'X'

        self.dfs(i,j,board)
        return board
    
    def dfs(self,i,j,board):
        # Terminator
        if  i < 0 or j < 0 or i >= len(board) or j >= len(board[0]) or board[i][j] != 'E':
            return 

        # Better to build a direction list for iteration later
        directions = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        mine_count = 0
        for d in directions:
            # Remember to check the boundary
            if 0 <= i+d[0] < len(board) and 0 <= j+d[1] < len(board[0]):
                if board[i + d[0]][j + d[1]] == 'M':
                    mine_count += 1
        
        if mine_count == 0:
            board[i][j] = 'B'
        else:
            board[i][j] = str(mine_count)
            # if find mine near the block, no need to deep dive any more
            return 

        for d in directions:
            self.dfs(i + d[0],j + d[1],board)

# dfs by playboy9817
## https://leetcode.com/problems/minesweeper/discuss/99897/10-line-python-solution
class Solution(object):
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        row,col, directions = click[0],click[1], ((-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1))
        if 0 <= row < len(board) and 0<= col <len(board[0]):
            if board[row][col]=='M':
                board[row][col]='X'
            elif board[row][col] =='E':
                n = sum(board[row+r][col+c]=='M' for r,c in directions if 0<=row + r<len(board) and 0<=col+c<len(board[0]))
                board[row][col] = str(n or 'B')
                not n and map(self.updateBoard,(board,) * 8, [(row + d[0], col+d[1]) for d in directions])
        return board
# @lc code=end

