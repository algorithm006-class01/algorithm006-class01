/**
 * 解题思路: 动态规划思路，s[i]-s[j]之间是否为回文取决于s[i+1]-s[j-1]是否为回文及i j位置元素是否相同
 * dp数组定义：dp[i][j]代表i-j之间字符串是否为回文
 * 转移方程：dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 * 执行用时: 13 ms, 在所有 Java 提交中击败了28.93%的用户
 * 内存消耗: 42.2 MB, 在所有 Java 提交中击败了5.13%的用户
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aabaa"));
        System.out.println(countSubstrings("fdsklf"));
        System.out.println(countSubstrings("a"));
    }

    public static int countSubstrings(String s) {
        int result = 0;
        // 边界条件
        if (null == s || s.length() == 0) {
            return result;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && ((i - j) < 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }
}