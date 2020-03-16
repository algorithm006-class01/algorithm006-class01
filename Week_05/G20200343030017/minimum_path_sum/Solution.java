package week5.minimum_path_sum;

public class Solution {
    //max(x,y)=a[y-1][x]+a[y][x]
    //max(x,y)=a[y][x-1]+a[y][x]
    public int minPathSum(int[][] grid) {
        int[][] dp = grid;
        for (int y=0;y<grid.length;y++){
            for (int x=0;x<grid[0].length;x++){
                if (x==0&&y==0){
                    dp[y][x]=grid[y][x];
                    continue;
                }
                if (x==0){
                    dp[y][x]=dp[y-1][x]+grid[y][x];
                }else if(y==0){
                    dp[y][x]=dp[y][x-1]+grid[y][x];
                }else{
                    dp[y][x]=Math.min(dp[y-1][x],dp[y][x-1])+grid[y][x];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{ {1,3,1},
                                    {1,5,1},
                                    {4,2,1}};
        Solution s = new Solution();
        System.out.println(s.minPathSum(grid));
    }
}
