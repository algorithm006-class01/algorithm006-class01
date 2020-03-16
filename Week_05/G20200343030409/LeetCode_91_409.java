/*

    time complexity: O(n), space complexity: O(n)

*/
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];

        dp[0] = 1; // empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= n; i++) {
            // 枚舉最後一個字母對應2位, 成立代表在 i-2 位置上可以有方法
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }

            // 枚舉最後一個字母對應1位, 成立代表在 i-1 位置上可以有方法
            int oneDigit = Integer.parseInt(s.substring(i-1, i));

            if(oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i-1];
            }
        }

        return dp[n];
    }
}