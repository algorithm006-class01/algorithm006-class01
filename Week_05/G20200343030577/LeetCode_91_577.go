package leetcode

/*
 * @lc app=leetcode.cn id=91 lang=golang
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.96%)
 * Likes:    311
 * Dislikes: 0
 * Total Accepted:    36.8K
 * Total Submissions: 158.3K
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
// create time:2020-03-15 22:44
// @lc code=start
func numDecodings(s string) int {
	return numDecodingsDP(s)
}

func numDecodingsDP(s string) int {
	if len(s) == 0 {
		return 0
	}
	dp := make([]int, len(s))
	dp[0] = 1
	if s[0] == '0' {
		dp[0] = 0
	}
	for i := 1; i < len(s); i++ {
		if !(s[i] >= '0' && s[i] <= '9') {
			return 0
		}
		if s[i] == '0' {
			if s[i-1] == '1' || s[i-1] == '2' {
				if i-2 >= 0 {
					dp[i] = dp[i-2]
				} else {
					dp[i] = 1
				}
			} else {
				return 0
			}
			continue
		}

		if s[i-1] == '2' {
			if s[i] >= '1' && s[i] <= '6' {
				if i-2 >= 0 {
					dp[i] = dp[i-1] + dp[i-2]
				} else {
					dp[i] = dp[i-1] + 1
				}
			} else {
				dp[i] = dp[i-1]
			}
			continue
		}

		if s[i-1] == '1' {
			if i-2 >= 0 {
				dp[i] = dp[i-2] + dp[i-1]
			} else {
				dp[i] = dp[i-1] + 1
			}
			continue
		}
		dp[i] = dp[i-1]
	}
	return dp[len(dp)-1]
}

// @lc code=end
