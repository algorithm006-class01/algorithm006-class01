/*
 * @lc app=leetcode.cn id=5 lang=golang
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (28.77%)
 * Likes:    1957
 * Dislikes: 0
 * Total Accepted:    224.7K
 * Total Submissions: 769K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
func longestPalindrome(s string) string {
    lenth := len(s)

    if lenth <= 1 {
        return s
    }

    dp := make([][]bool, lenth)
    
    start := 0
    maxlen := 1

    for r := 0;r<lenth;r++ {
        dp[r] = make([]bool, lenth)
        dp[r][r] = true
        for l:=0;l<r;l++ {
            if s[l] == s[r] && (r -l <= 2 || dp[l+1][r-1]) {
                dp[l][r] = true
            }else{
                dp[l][r] = false
            }

            if dp[l][r] {
                curlen := r-l+1
                if curlen > maxlen {
                    maxlen = curlen
                    start = l
                }
            }
        }
    }
    return s[start:start+maxlen]
}

// @lc code=end

