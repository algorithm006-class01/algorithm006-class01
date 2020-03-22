package dynamic;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int value = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + value);
            }
        }
        return dp[m][n];
    }

    private int min(int v1, int v2, int v3) {
        return v1 <= v2 ? (v1 <= v3 ? v1 : v3) : (v2 <= v3 ? v2 : v3);
    }

    public static void main(String[] args) {
        EditDistance distance = new EditDistance();
        System.out.println(distance.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}
