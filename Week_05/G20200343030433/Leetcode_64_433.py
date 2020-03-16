m = len(grid)
        n = len(grid[0])
        dp = [0]*n
        dp[0] = grid[0][0]
        for k in range(1,n):
            dp[k] = dp[k-1] + grid[0][k] 
        for i in range(1,m):
            for j in range(0,n):
                if j == 0 : dp[j] += grid[i][j]
                else:
                    dp[j] = min(dp[j-1],dp[j])+grid[i][j]
        return dp[-1]
