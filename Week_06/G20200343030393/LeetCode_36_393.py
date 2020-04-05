class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        big = set()
        for i in range(0, 9):
            for j in range(0, 9):
                if board[i][j] != '.':
                    cur = board[i][j]
                    if (i, cur) in big or (cur, j) in big or (i / 3, j / 3, cur) in big:
                        return False
                    big.add((i, cur))
                    big.add((cur, j))
                    big.add((i / 3, j / 3, cur))
        return True


board = [
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]

aa = Solution()
print(aa.isValidSudoku(board))
