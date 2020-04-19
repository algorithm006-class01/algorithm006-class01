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
    // 解决方案：暴力法
    // 时间复杂度：O(2^2n * n)
    // 空间复杂度：O(n) 答案数组除外，空间取决于递归栈的深度
    public List<String> generateParenthesis2(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2*n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) result.add(String.valueOf(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }

        return 0 == balance;
    }

    // 解决方案：回溯法
    //         如果左括号数量不大于n，我们可以放一个左括号；
    //         如果右括号数量小于左括号的数量，我们可以放一个有括号；
    // 时间复杂度：O(4^n/n^0.5)
    // 空间复杂度：O(n) 递归栈的深度
    public List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    // 解决方案：动态规划
    //        递推方程：dp[i] = "(" + dp[j] + ")" + dp[i - j - 1], j = 0, 1, ..., i - 1
    // 时间复杂度：暂时不会分析
    // 空间复杂度：
    public List<String> generateParenthesis4(int n) {
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

    // 按括号序列的长度递归
    // 时间复杂度：O(4^n/n^0.5)
    // 空间复杂度：O(n)
    ArrayList[] cache = new ArrayList[100];
    public List<String> generateParenthesis(int n) {
        if (cache[n] != null) return cache[n];
        
        ArrayList<String> ans = new ArrayList();
        if (0 == n) ans.add("");
        else {
            for (int c = 0; c < n; c++) {
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
            }
        }
        cache[n] = ans;
        return ans;
    }
}
// @lc code=end

