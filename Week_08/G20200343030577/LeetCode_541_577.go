package leetcode

/*
 * @lc app=leetcode.cn id=541 lang=golang
 *
 * [541] 反转字符串 II
 *
 * https://leetcode-cn.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (51.60%)
 * Likes:    69
 * Dislikes: 0
 * Total Accepted:    13.2K
 * Total Submissions: 24.9K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k
 * 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 *
 * 要求:
 *
 *
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 *
 */

// @lc code=start
func reverseStr(s string, k int) string {
	if len(s) == 0 || k <= 0 {
		return s
	}
	s2b := []byte(s)
	start, end := 0, 2*k
	if end > len(s2b) {
		end = len(s2b)
	}
	for start < end {

		switch {
		// <k
		case (end - start) < k:
			for i, j := start, end-1; i < j; i, j = i+1, j-1 {
				s2b[i], s2b[j] = s2b[j], s2b[i]
			}
		// (>=k && < 2k) ||  ==2k
		default:
			for i, j := start, start+k-1; i < j; i, j = i+1, j-1 {
				s2b[i], s2b[j] = s2b[j], s2b[i]
			}
		}
		start, end = end, end+2*k
		if end > len(s2b) {
			end = len(s2b)
		}
	}
	return string(s2b)
}

// @lc code=end
