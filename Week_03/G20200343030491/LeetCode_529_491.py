class Solution:
    
    
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        row, col = click[0], click[1]
    
    

        dx = [-1, -1, -1, 0, 1, 1, 1,  0]
        dy = [-1, 0,  1,  1, 1, 0, -1, -1]


        if board[row][col] == 'M':
            board[row][col] = 'X'
            return board

        visited = set()

        def adjacent(row, col):
            mine = 0
            for k in range(len(dx)):
                if row+dx[k]>=0 and row+dx[k]<len(board) and col+dy[k]>=0 and col+dy[k]<len(board[0]):
                    if board[row + dx[k]][col + dy[k]] == "M":
                        mine += 1
            return mine

        def rec(row,col):
            if (row, col) not in visited:
                visited.add((row, col))

                if board[row][col] == 'E':
                    adjacentMine = adjacent(row,col)
                    if adjacentMine != 0:
                        board[row][col] = str(adjacentMine)
                    else:
                        board[row][col] = 'B'
                        for k in range(len(dx)):
                            if row+dx[k]>=0 and row+dx[k]<len(board) and col+dy[k]>=0 and col+dy[k]<len(board[0]):
                                rec(row+dx[k],col+dy[k])
        rec(row,col)
        return board
