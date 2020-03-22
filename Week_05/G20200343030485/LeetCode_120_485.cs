public class Solution {
    public int MinimumTotal(IList<IList<int>> triangle) {
        int row = triangle.Count;
        int[] dp = new int[row + 1];
        for (int i = row - 1; i >= 0; i--) {
            int num = triangle[i].Count;
            for (int j = 0; j < num; j++) {
                dp[j] = Math.Min(dp[j], dp[j + 1]) + triangle[i][j]; 
            } 
        }

        return dp[0];
    }
}