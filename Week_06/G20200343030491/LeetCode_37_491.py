class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = [set(range(1,10)) for _ in range(9)]
        cols = [set(range(1,10)) for _ in range(9)]
        boxes = [set(range(1,10)) for _ in range(9)]
        empty = []
        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    rows[i].remove(int(board[i][j]))
                    cols[j].remove(int(board[i][j]))
                    boxes[i//3*3+j//3].remove(int(board[i][j]))
                else:
                    empty.append((i,j))
                    
        def dfs(iter=0):
            if iter == len(empty):
                return True
            i, j = empty[iter]
            for val in rows[i] & cols[j] & boxes[i//3*3+j//3]:
                rows[i].remove(val)
                cols[j].remove(val)
                boxes[i//3*3+j//3].remove(val)
                board[i][j] = str(val)
                if dfs(iter+1):
                    return True
                rows[i].add(val)
                cols[j].add(val)
                boxes[i//3*3+j//3].add(val)
            return False
        
        dfs()