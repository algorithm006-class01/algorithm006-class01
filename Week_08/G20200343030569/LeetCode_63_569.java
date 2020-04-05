package week08;
/*
 * 63. Unique Paths II
 * 
 * 个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右

 */
public class LeetCode_63_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * dp[i][j] i表示行坐标，j表示列坐标，dp[i][j]表示在i,j这个坐标的路径数
	 * dp[i][j] = dp[i-1][j] + dp[i][j-1];  i,j路径等于上面点路径和左边点路径之和
	 * 第一行第一列路径皆为1，如果有障碍则该点和后续皆为0
	 */
	class Solution {
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    	if( obstacleGrid[0][0] == 1 )
	    		return 0;
	    	int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
	    	dp[0][0] = 1;
	    	for( int i = 1; i < dp.length; i++ )
	    		dp[i][0] =( dp[i-1][0] == 1 && obstacleGrid[i][0] != 1 ) ? 1 : 0;
	    	for( int i = 1; i < dp[0].length; i++ )
	    		dp[0][i] =( dp[0][i-1] == 1 && obstacleGrid[0][i] != 1 ) ? 1 : 0;
	    	for( int i = 1; i < dp.length; i++ ) {
	    		for( int j = 1; j < dp[0].length; j++ ) {
	    			if( obstacleGrid[i][j] != 1 ) {
	    				dp[i][j] = dp[i-1][j] + dp[i][j-1];
	    			}else {
	    				dp[i][j] = 0;
	    			}
	    		}
	    	}
	    	return dp[dp.length-1][dp[0].length-1];
	    }
	}
}
