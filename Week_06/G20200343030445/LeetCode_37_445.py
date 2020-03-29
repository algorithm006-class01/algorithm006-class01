#
# @lc app=leetcode.cn id=37 lang=python3
#
# [37] 解数独
#

# @lc code=start
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = [set(range(1,10)) for _ in range(9)]
        col = [set(range(1,10)) for _ in range(9)]
        block = [set(range(1,10)) for _ in range(9)]

        empty = []
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    empty.append((i, j))
                else:
                    row[i].remove(int(board[i][j]))
                    col[j].remove(int(board[i][j]))
                    block[(i // 3) * 3 + j // 3].remove(int(board[i][j]))
        
        def recur(level):
            if len(empty) == level:
                return True
            e = empty[level]
            i, j = e[0], e[1]
            
            for c in row[i] & col[j] & block[(i // 3) * 3 + j // 3]:
                row[i].remove(c)
                col[j].remove(c)
                block[(i // 3) * 3 + j // 3].remove(c)             
                board[i][j] = str(c)

                if recur(level + 1):
                    return True
                
                row[i].add(c)
                col[j].add(c)
                block[(i // 3) * 3 + j // 3].add(c)
                board[i][j] = "."

            return False
        
        recur(0)

                
# @lc code=end

