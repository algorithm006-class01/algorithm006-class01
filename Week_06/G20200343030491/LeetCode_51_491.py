class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.']*n for _ in range(n)]
        ans = []

        def isValid(board, row, col):
            n = len(board)
            for i in range(n):
                if board[i][col] == "Q":
                    return False

            r, c = row-1, col+1
            while r>=0 and c<n:
                if board[r][c] == "Q":
                    return False
                r -= 1
                c += 1

            r, c = row-1, col-1
            while r>=0 and c>=0:
                if board[r][c] == "Q":
                    return False
                r -= 1
                c -= 1

            return True

        def backtrack(board,row):
            if row == len(board):
                tmpList = []
                for row in board:
                    tmp = ''.join(row)
                    tmpList.append(tmp)
                ans.append(tmpList)
                return

            col = len(board[row])
            for j in range(col):
                if not isValid(board, row, j):
                    continue

                board[row][j] = "Q"
                backtrack(board,row+1)
                board[row][j] = "."

        backtrack(board,0)

        return ans
        

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        def dfs(queen,rightup,leftup):
            row = len(queen)
            if row==n:
                res.append(queen)
                return
            for col in range(n):
                if col not in queen and col+row not in rightup and col-row not in leftup:
                    dfs(queen+[col], rightup+[col+row], leftup+[col-row])
                
        dfs([],[],[])
        print(res)
        return [['.'*i + 'Q' + '.'*(n-i-1) for i in sol] for sol in res]