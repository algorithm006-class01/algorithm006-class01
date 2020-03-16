/*
 * 64. Minimum Path Sum
 * 最小路径和
 * 
 * 
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

 */
public class LeetCode_64_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
					{1, 3, 1 },
					{1, 5, 1},
					{4, 2, 1}
				};
		int result = new LeetCode_64_569().new Solution().minPathSum(grid);
		System.out.println( result);
	}
	
	/*
	 * 从终点到起点
	 * 分治： problem[i,j] = min( subproblem[i+1,j], subproblem[i,j+1] )
	 * 状态表： grid[i,j]
	 * dp方程: f[i,j] = min( f[i+1,j], f[i,j+1] ) + grid[i,j];
	 * 
	 */

	class Solution {
	    public int minPathSum(int[][] grid) {
	    	for(int i = grid.length -1; i>=0; i-- ) {
	    		for( int j = grid[0].length-1; j>=0; j-- ) {
	    			if( i == grid.length-1 && j != grid[0].length -1 ) {
	    				grid[i][j] = grid[i][j] + grid[i][j+1];
	    			}else if( j == grid[0].length-1 && i != grid.length-1 ) {
	    				grid[i][j] = grid[i][j] + grid[i+1][j];
	    			}else if( i != grid.length-1 && j != grid[0].length-1 ) {
	    				grid[i][j] = Math.min(grid[i+1][j], grid[i][j+1]) + grid[i][j];
	    			}
	    		}
	    	}
	    	return grid[0][0];
	    }
	}
}
