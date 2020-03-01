/*
 * @lc app=leetcode.cn id=49 lang=golang
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (60.53%)
 * Likes:    271
 * Dislikes: 0
 * Total Accepted:    51.4K
 * Total Submissions: 84.4K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 *
 * 说明：
 *
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 *
 */
package leetcode

import "sort"

// @lc code=start
// create time:2020-02-23 19:37
func groupAnagrams(strs []string) [][]string {
	return groupAnagramsUseSortAndHash(strs)
	// return groupAnagramsUseCountAndHash(strs)
}

func groupAnagramsUseSortAndHash(strs []string) [][]string {
	if len(strs) == 0 {
		return nil
	}
	// 将子集存放于hash表中
	ans := make(map[string][]int)
	for i := range strs {
		// 排序
		b := []byte(strs[i])
		sort.Slice(b, func(i, j int) bool {
			return b[i] <= b[j]
		})
		if _, ok := ans[string(b)]; ok {
			ans[string(b)] = append(ans[string(b)], i)
		} else {
			ans[string(b)] = append(make([]int, 0, 1), i)
		}

	}
	// 从hash表中获取结果
	res, count := make([][]string, len(ans)), 0
	for _, index := range ans {
		child := make([]string, 0, len(index))
		for _, i := range index {
			child = append(child, strs[i])
		}
		res[count] = child
		count++
	}
	return res
}

func groupAnagramsUseCountAndHash(strs []string) [][]string {
	if len(strs) == 0 {
		return nil
	}

	ans := make(map[[26]int][]int)
	for i := range strs {
		var s [26]int
		for j := range strs[i] {
			s[strs[i][j]-'a']++
		}
		if _, ok := ans[s]; ok {
			ans[s] = append(ans[s], i)
		} else {
			ans[s] = append(make([]int, 0, 1), i)
		}
	}
	res, count := make([][]string, len(ans)), 0
	for _, index := range ans {
		child := make([]string, 0, len(index))
		for _, i := range index {
			child = append(child, strs[i])
		}
		res[count] = child
		count++
	}
	return res
}

// @lc code=end
