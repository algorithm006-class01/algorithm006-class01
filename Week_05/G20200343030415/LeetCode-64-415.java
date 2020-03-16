class Solution {

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1){
                    //dp[j+1]是右边的
                    dp[j] = grid[i][j] + dp[j+1];
                }else if(i != grid.length - 1 && j == grid[0].length - 1){

                    dp[j] = grid[i][j] + dp[j];//dp[j]是上一行的
                }else if(i != grid.length - 1 && j != grid[0].length - 1){
                    dp[j] = Math.min(dp[j],dp[j+1]) + grid[i][j];
                }else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}