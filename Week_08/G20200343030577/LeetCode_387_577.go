package leetcode

/*
 * @lc app=leetcode.cn id=387 lang=golang
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (43.06%)
 * Likes:    199
 * Dislikes: 0
 * Total Accepted:    69.5K
 * Total Submissions: 157K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 */

// @lc code=start
func firstUniqChar(s string) int {
	if len(s) == 0 {
		return -1
	}
	countM := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		if _, ok := countM[s[i]]; !ok {
			countM[s[i]] = 0
		}
		countM[s[i]]++
	}

	for i := 0; i < len(s); i++ {
		if countM[s[i]] == 1 {
			return i
		}
	}

	return -1
}

// @lc code=end
