class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
			}
		}
		int res = Integer.MIN_VALUE;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				for (int l = 1; l <= m; l++) {
					for (int o = 1; o <= n; o++) {
						if(i+l-1 <= m && j+o-1 <= n){
							int ar = i+l-1, ac = j+o-1, br = i-1, bc = j-1;
							int sum = dp[ar][ac] + dp[br][bc] - dp[ar][bc] - dp[br][ac];
							if(sum <= k) res = Math.max(res, sum);
						}
					}
				}
			}
		}
		return res;
    }
}
