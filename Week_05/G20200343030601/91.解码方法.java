/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.20%)
 * Likes:    311
 * Dislikes: 0
 * Total Accepted:    36.7K
 * Total Submissions: 158.1K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    // if 第1位是1～9，则合法，继续解码后面的
    // if 前2位是10～26，也合法，继续解码后面的
    // 递归方式解决此问题，明显存在重复计算问题
    public int numDecodings1(String s) {
        if (null == s || 0 == s.length()) return 0;
        int result = 0;

        // 解码第一位
        int value = s.charAt(0) - '0';
        if (value > 0 && value < 10)
            result += (s.length() > 1 ? numDecodings(s.substring(1)) : 1);
        
        // 解码前两位
        if (s.length() > 1) {
            value = 10 * (s.charAt(0) - '0') + (s.charAt(1) - '0');
            if (value >= 10 && value <= 26)
                result += (s.length() > 2? numDecodings(s.substring(2)) : 1);
        }

        return result;
    }

    // 动态规划
    // if 第1位是1～9，则合法，记后序解法为count1
    // if 前2位是10～26，也合法，记后序解法为count2
    // 总解法count = count1 + count2
    // 空间复杂度：O(n)
    public int numDecodings2(String s) {
        if (null == s || s.length() == 0) return 0;
        
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) != '0'? 1 : 0;
        
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') // 此时一位、两位都无效
                continue;
            else
            {
                dp[i] += dp[i + 1]; // 一位有效
                int value = 10 * (s.charAt(i) - '0') + (s.charAt(i + 1) - '0');
                if (value >= 10 && value <= 26)
                    dp[i] += dp[i + 2];  // 两位有效
            }
        }

        return dp[0];
    }

    // 动态规划
    // if 第1位是1～9，则合法，记后序解法为count1
    // if 前2位是10～26，也合法，记后序解法为count2
    // 总解法count = count1 + count2
    // 空间复杂度：O(1)
    public int numDecodings(String s) {
        if (null == s || s.length() == 0) return 0;
        
        int count = 0, count1 = 0, count2 = 1;
        if (s.charAt(s.length() - 1) != '0') {
            count = 1;
            count1 = 1;
        }
        
        for (int i = s.length() - 2; i >= 0; i--) {
            count = 0;
            if (s.charAt(i) != '0')
            {
                count = count1; // 一位有效
                count += (10 * (s.charAt(i) - '0') + (s.charAt(i + 1) - '0') <= 26)? count2 : 0;  // 两位有效
            }

            count2 = count1;
            count1 = count;
        }

        return count;
    }
}
// @lc code=end

