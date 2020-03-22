#
# @lc app=leetcode id=51 lang=python3
#
# [51] N-Queens
#
# https://leetcode.com/problems/n-queens/description/
#
# algorithms
# Hard (43.64%)
# Likes:    1489
# Dislikes: 65
# Total Accepted:    181.5K
# Total Submissions: 412.8K
# Testcase Example:  '4'
#
# The n-queens puzzle is the problem of placing n queens on an n×n chessboard
# such that no two queens attack each other.
# 
# 
# 
# Given an integer n, return all distinct solutions to the n-queens puzzle.
# 
# Each solution contains a distinct board configuration of the n-queens'
# placement, where 'Q' and '.' both indicate a queen and an empty space
# respectively.
# 
# Example:
# 
# 
# Input: 4
# Output: [
# ⁠[".Q..",  // Solution 1
# ⁠ "...Q",
# ⁠ "Q...",
# ⁠ "..Q."],
# 
# ⁠["..Q.",  // Solution 2
# ⁠ "Q...",
# ⁠ "...Q",
# ⁠ ".Q.."]
# ]
# Explanation: There exist two distinct solutions to the 4-queens puzzle as
# shown above.
# 
# 
#

# @lc code=start
# 使用 permutation 的方法
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        positions = []
        visited = [False for i in range(n)]
        self.dfs(n, visited, [], positions)
        result = []
        for cols in positions:
            result.append(self.draw_chessboard(cols))
        return result
        
    def dfs(self, n, visited, cols, positions):
        if len(cols) == n:
            positions.append(cols[:])
            return
        
        for i in range(n):
            if not self.is_valid(cols, i):
                continue
            if visited[i]:
                continue
            visited[i] = True
            self.dfs(n, visited, cols + [i], positions)
            visited[i] = False
            
    def is_valid(self, cols, column):
        row = len(cols)
        for r, c in enumerate(cols):
            if r + c == row + column:
                return False
            if r - c == row - column:
                return False
        return True

    def draw_chessboard(self, cols):
        board = []
        for row, col in enumerate(cols):
            board_row = ['Q' if i == col else '.' for i in range(len(cols))]
            board.append(''.join(board_row))
        return board

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        visited = {
            'col': set(),
            'sum': set(),
            'diff': set()
        }
        self.dfs(n, visited, [], result)
        return result

    def dfs(self, n, visited, cols, result):
        if len(cols) == n:
            result.append(self.draw_chessboard(cols))
        
        for col in range(n):
            if not self.is_valid(visited, col, cols):
                continue
            visited['col'].add(col)
            visited['sum'].add(col + len(cols))
            visited['diff'].add(col - len(cols))
            self.dfs(n, visited, cols + [col], result)
            visited['col'].remove(col)
            visited['sum'].remove(col + len(cols))
            visited['diff'].remove(col - len(cols))
        

    def is_valid(self, visited, col, cols):
        row = len(cols)
        if col in visited['col']:
            return False
        if col + row in visited['sum']:
            return False
        if col - row in visited['diff']:
            return False
        return True

    def draw_chessboard(self, cols):
        board = []
        for col in cols:
            board_row = ['Q' if i == col else '.' for i in range(len(cols))]
            board.append(''.join(board_row))
        return board


# @lc code=end

