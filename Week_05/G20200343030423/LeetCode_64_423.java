public class LeetCode_64_423 {
}

class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // init row
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        // init clols
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i][j-1],grid[i-1][j]) + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}