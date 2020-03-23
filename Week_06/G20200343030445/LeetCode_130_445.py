#
# @lc app=leetcode.cn id=130 lang=python3
#
# [130] 被围绕的区域
#

# @lc code=start
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        
        m = len(board)
        n = len(board[0])

        def dfs(i, j):
            # termination
            if i < 0 or j < 0 or i >= m or j >= n or board[i][j] == "X" or board[i][j] == "#":
                return
            board[i][j] = '#'
            # for 4 directions: search
            for d in ((-1,0), (1,0), (0,-1), (0,1)):
                dfs(i+d[0], j+d[1])
            
        for i in range(m):
            for j in range(n):
                if (i == 0 or j == 0 or i == m-1 or j == n-1) and board[i][j] == "O":
                    dfs(i, j)
        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    board[i][j] = "X"
                if board[i][j] == "#":
                    board[i][j] = "O"

# @lc code=end

