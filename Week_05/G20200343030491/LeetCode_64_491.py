
def minPathSum(grid):
    if not grid:
        return 0
    
    m = len(grid)
    n = len(grid[0])

    dp = grid.copy()
    for i in range(1,m):
        dp[i][0] += dp[i-1][0]
    for i in range(1,n):
        dp[0][i] += dp[0][i-1]
        
    for i in range(1,m):
        for j in range(1,n):
            dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + dp[i][j]

    return dp[m-1][n-1]


def minPathSumDFS(grid):
    if not grid or not grid[0]:
        return 0
    m, n = len(grid), len(grid[0])
    memo = [[-1] * n for _ in range(m)]

    def dfs(r,c):
        if r==m-1 and c==n-1:return grid[r][c]
        if r < m and c < n and memo[r][c] != -1: return memo[r][c]
        elif c >= n-1:
            memo[r][c] = dfs(r+1,c) + grid[r][c]
        elif r >= m-1:
            memo[r][c] = dfs(r,c+1) + grid[r][c]
        else:
            memo[r][c] = min(dfs(r+1,c), dfs(r,c+1)) + grid[r][c]
        
        return memo[r][c]

    return dfs(0,0)
     