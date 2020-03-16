
/*
 * 221. Maximal Square
 * 最大正方形
 * 
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4


 */
public class LeetCode_221_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {
				{ '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' }
		};
		
		int result = new LeetCode_221_569().new Solution().maximalSquare(matrix);
		System.out.println(result);
	}

	/*
	 * 看来的别人的思路，关键在于状态方程 
	 * 状态数组dp[i][j],里面放的是最大长方形边长
	 * 状态方程： dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
	 * if (grid(i, j) == 1) {
    		dp(i, j) = min(dp(i-1, j), dp(i, j-1), dp(i-1, j-1)) + 1;
	   }
	 */
	
	class Solution {
	    public int maximalSquare(char[][] matrix) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        int[][] dp = new int[rows + 1][cols + 1];
	        int maxsqlen = 0;
	        for (int i = 1; i <= rows; i++) {
	            for (int j = 1; j <= cols; j++) {
	                if (matrix[i-1][j-1] == '1'){
	                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
	                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
	                }
	            }
	        }
	        return maxsqlen * maxsqlen;
	    }
	}
}
