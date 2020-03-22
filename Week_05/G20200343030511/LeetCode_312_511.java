class Solution {
    public int maxCoins(int[] nums) {
if (nums == null || nums.length == 0)
			return 0;
		// 创建虚拟数组
		int[] coins = new int[nums.length + 2];
		System.arraycopy(nums, 0, coins, 1, nums.length);
		coins[0] = 1;
		coins[coins.length - 1] = 1;
		int length = coins.length;
		int[][] cached = new int[length][length];
		return maxCoins_help(coins, 0, length-1, cached);
	}

	private int maxCoins_help(int[] nums, int start, int end, int[][] cached) {
		// 终止条件
		if (start == end - 1) {
			return 0;
		}
		if (cached[start][end] != 0)
			return cached[start][end];
		// 当前处理
		// 维护一个最大值
		int max = 0;
		for (int i = start + 1; i < end; i++) {
			int temp = maxCoins_help(nums, start, i, cached) + maxCoins_help(nums, i, end, cached)
					+ nums[start] * nums[i] * nums[end];
			if (temp > max)
				max = temp;
		}
		// 下一层递归
		// 状态处理
		cached[start][end] = max;
		return max;
}


public int maxCoins2(int[] nums) {
		if (nums.length == 0) { 
			return 0;
		}
		int[] coins = new int[nums.length + 2];
		System.arraycopy(nums, 0, coins, 1, nums.length);
		coins[0] =coins[coins.length - 1]= 1;
		int dp[][] = new int[coins.length][coins.length];
/*		for (int i = 0; i < dp.length - 1; i++) {
			dp[i][i + 1] = 0;
		}*/
		int n = coins.length;
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = i + len - 1;
				dp[i][j] = Integer.MIN_VALUE;
				// 枚举中间的气球
				for (int k = i + 1; k <= j - 1; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + coins[i] * coins[k] * coins[j]);
				}
			}
		}
		return dp[0][coins.length - 1];
	}
}