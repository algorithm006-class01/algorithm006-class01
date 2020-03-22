/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.50%)
 * Likes:    810
 * Dislikes: 0
 * Total Accepted:    87.7K
 * Total Submissions: 119.1K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
class Solution {
    // 动态规划解决方案
    // dp[i] = "(" + dp[j] + ")" + dp[i - j - 1], j = 0, 1, ..., i - 1
    // 时间复杂度：暂时不会分析
    // 空间复杂度：
    public List<String> generateParenthesis(int n) {
        if (0 == n) return new ArrayList<String>();

        List<List<String>> dp = new ArrayList<>(n+1);
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> curStrList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> strList1 = dp.get(j);
                List<String> strList2 = dp.get(i - j - 1);
                for (String str1 : strList1) {
                    for (String str2 : strList2) { 
                        curStrList.add("(" + str1 + ")" + str2);
                    }
                }
            }
            dp.add(curStrList);
        }

        return dp.get(n);
    }
}
// @lc code=end

