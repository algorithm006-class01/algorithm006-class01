class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]: return -1
        if grid[0][0] == 1: return -1
        m, n = len(grid), len(grid[0])
        dx = [-1,0,1,0,-1,1,1,-1]
        dy = [0,-1,0,1,-1,-1,1,1]
        q = deque()
        q.append((0,0,1))
        visited = set()
        visited.add((0,0))
        while q:
            x,y,lev = q.popleft()
            if x == m-1 and y == n-1:
                return lev
            for i in range(len(dx)):
                if 0<=x+dx[i]<m and 0<=y+dy[i]<n and (x+dx[i],y+dy[i]) not in visited and grid[x+dx[i]][y+dy[i]]==0:
                    q.append((x+dx[i],y+dy[i],lev+1))
                    visited.add((x+dx[i],y+dy[i]))

        return -1

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]: return -1
        if grid[0][0] == 1: return -1
        m, n = len(grid), len(grid[0])
        dx = [-1,0,1,0,-1,1,1,-1]
        dy = [0,-1,0,1,-1,-1,1,1]
        q = deque()
        q.append((0,0))
        visited = set()
        visited.add((0,0))
        step = 1
        while q:
            newQ = q
            q = deque([])
            while newQ:
                x,y = newQ.popleft()
                if x == m-1 and y == n-1:
                    return step
                for i in range(len(dx)):
                    if 0<=x+dx[i]<m and 0<=y+dy[i]<n and (x+dx[i],y+dy[i]) not in visited and grid[x+dx[i]][y+dy[i]]==0:
                        q.append((x+dx[i],y+dy[i]))
                        visited.add((x+dx[i],y+dy[i]))
            step += 1

        return -1

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]: return -1
        m, n = len(grid), len(grid[0])
        if grid[0][0] == 1 or grid[m-1][n-1] == 1: return -1
        dx = [-1,0,1,0,-1,1,1,-1]
        dy = [0,-1,0,1,-1,-1,1,1]
        q = deque()
        q.append((0,0))
        visited = [[0]*n for _ in range(m)]
        visited[0][0] = 1
        while q:
            newQ = q
            q = deque([])
            while newQ:
                x,y = newQ.popleft()
                if x == m-1 and y == n-1:
                    return visited[x][y]
                for i in range(len(dx)):
                    if 0<=x+dx[i]<m and 0<=y+dy[i]<n and visited[x+dx[i]][y+dy[i]]==0 and grid[x+dx[i]][y+dy[i]]==0:
                        q.append((x+dx[i],y+dy[i]))
                        visited[x+dx[i]][y+dy[i]] = visited[x][y] + 1
        return -1


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]: return -1
        m = len(grid)
        n = len(grid[0])
        if grid[0][0] != 0 or grid[m-1][n-1] != 0: return -1

        dx = [-1,-1,0,1,1,1,0,-1]
        dy = [0,-1,-1,-1,0,1,1,1]

        visited = set()
        visited.add((0,0))
        beginQ, endQ = deque(), deque()
        beginQ.append((0,0))
        endQ.append((m-1,n-1))
        step = 1

        while beginQ:
            nextQ = beginQ
            beginQ = deque([])
            while nextQ:
                x, y = nextQ.popleft()
                if (x,y) in endQ:
                    return step
                for k in range(len(dx)):
                    if 0<=x+dx[k]<m and 0<=y+dy[k]<n and grid[x+dx[k]][y+dy[k]] == 0 and (x+dx[k],y+dy[k]) in endQ:
                        return step + 1
                    if 0<=x+dx[k]<m and 0<=y+dy[k]<n and grid[x+dx[k]][y+dy[k]] == 0 and (x+dx[k],y+dy[k]) not in visited:
                        beginQ.append((x+dx[k],y+dy[k]))
                        visited.add((x+dx[k],y+dy[k]))

            if len(endQ) < len(beginQ):
                beginQ, endQ = endQ, beginQ
            step += 1

        return -1