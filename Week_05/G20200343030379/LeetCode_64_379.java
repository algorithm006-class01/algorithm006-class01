package G20200343030379;
/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m?x?n?网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 * ? [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode_64_379 {
    //动态规划 二维矩阵 自顶向下
    /** 重复性：Min(dp[i,j-1],dp[i-1,j])+grip[i,j];
     *  定义状态数组 dp[i,j]
     *  DP方程：dp[i,j]=Min(dp[i,j-1],dp[i-1,j])+grip[i,j];
     *
     *  执行用时 : 3 ms , 在所有 Java 提交中击败了 86.46% 的用户
     *  内存消耗 : 41.7 MB , 在所有 Java 提交中击败了 39.54% 的用户
    */
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int dp[][]=new int [grid.length][grid[0].length];



        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //边缘判断
                if(i==0 && j==0){
                    //第一个位置
                    //初始第一个位置
                    dp[0][0]=grid[0][0];
                }
                //顶部
                else if(i==0 && j>0){
                    dp[i][j]= dp[i][j-1]+grid[i][j];
                }else if(i>0 && j==0){
                    //最左边判断
                    dp[i][j]= dp[i-1][j]+grid[i][j];
                }else{
                    //其他位置
                    dp[i][j]= Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
                }
                //System.out.println(i+"===="+j+"==="+dp[i][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    /**
     * 一维动态规范：自顶向下
     *  重复性： Min(dp[j-1],dp[j]])+grip[i,j];
     *  定义状态数组 dp[i,j]
     *  DP方程：dp[j]=Min(dp[j-1],dp[j])+grip[i,j];
     *
     *  执行用时 : 3 ms , 在所有 Java 提交中击败了 86.46% 的用户
     *  内存消耗 : 42.4 MB , 在所有 Java 提交中击败了 23.65% 的用户
     */
    public int minPathSum2(int[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int dp[]=new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
               // System.out.println(i+"===="+j+"==="+dp[i]);
                if(i==0 && j>0){
                    dp[j]=grid[i][j]+dp[j-1];
                }
                else if(j==0){
                    dp[j]=grid[i][j]+dp[j];
                }else{
                    dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
                }
            }
        }
        return dp[grid[0].length-1];
    }
}
