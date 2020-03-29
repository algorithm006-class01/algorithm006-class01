class Solution:
    def __init__(self):
        self.parent = {}
    def _union(self,i,j):
        p1 = self._parent(i)
        p2 = self._parent(j)
        if p2 != p1:
            self.parent[p1] = p2
            
    def _parent(self,i):
        self.parent.setdefault(i,i)
        if self.parent[i] != i:
            self.parent[i] = self._parent(self.parent[i])
        return self.parent[i]
    
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return []
        m = len(board)
        n = len(board[0])
        dummy = m*n

        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    if i==0 or i==m-1 or j==0 or j==n-1:
                        self._union(i*n+j,dummy)
                        continue
                    if i>0 and board[i-1][j] == "O":
                        self._union(i*n+j, (i-1)*n+j)
                    if i<m-1 and board[i+1][j] == "O":
                        self._union(i*n+j, (i+1)*n+j)
                    if j>0 and board[i][j-1] == "O":
                        self._union(i*n+j, i*n+j-1)
                    if j<n-1 and board[i][j+1] == "O":
                        self._union(i*n+j, i*n+j+1)
                          
        # print(self.parent)
        for i in range(m):
            for j in range(n):
                if i*n+j in self.parent and self._parent(i*n+j) == self._parent(dummy):
                    board[i][j] = "O"
                else:
                    board[i][j] = "X"


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        if not board or not board[0]:
            return []
        
        m = len(board)
        n = len(board[0])
        dx = [-1,0,1,0]
        dy = [0,-1,0,1]
        visited = set()
        def dfs(x,y):
            if x<0 or x>m-1 or y<0 or y>n-1:
                return 
            visited.add((x,y))
            if board[x][y] == "O":
                board[x][y] = "G"
                
                for k in range(len(dx)):
                    if 0<x+dx[k]<m-1 and 0<y+dy[k]<n-1 and (x+dx[k],y+dy[k]) not in visited:
                        dfs(x+dx[k],y+dy[k])
        
        for i in [0,m-1]:
            for j in range(n):
                if board[i][j] == "O":
                    dfs(i,j)
        
        for i in range(m):
            for j in [0,n-1]:
                if board[i][j] == "O":
                    dfs(i,j)
        print(board)            
        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    board[i][j] = "X"
                    
                if board[i][j] == "G":
                    board[i][j] = "O"