//https://leetcode-cn.com/problems/group-anagrams/
package group_anagrams_test

//ToDo
import (
	"sort"
	"strconv"
	"testing"
)

func TestGroupAnagrams(t *testing.T) {
	t.Log("Group Anagrams")
}

func groupAnagrams(strs []string) [][]string {
	return mapCompare(strs)
}

//方法1：字符串排序
//O(n*klogk), k是字符串数组中最大字符串的长度
//O(n*k)
func stringSort(strs []string) [][]string {
	var res [][]string
	record := make(map[string][]string)
	for _, str := range strs {
		s := []rune(str)            // 把错位词的字符顺序重新排列，那么会得到相同的结果
		sort.Sort(sortRunes(s))     // 以此作为key，将所有错位词都保存到字符串数组中
		val, _ := record[string(s)] // 建立key和字符串数组之间的映射
		val = append(val, str)
		record[string(s)] = val
	}
	for _, v := range record {
		res = append(res, v)
	}
	return res
}

type sortRunes []rune

func (s sortRunes) Len() int           { return len(s) }
func (s sortRunes) Less(i, j int) bool { return s[i] < s[j] }
func (s sortRunes) Swap(i, j int)      { s[i], s[j] = s[j], s[i] }

//方法2：Map
//用一个大小为26的int数组来统计每个单词中字符出现的次数
//然后将int数组转为一个唯一的字符串，跟字符串数组进行映射
//O(n*k), O(n*k)
func mapCompare(strs []string) [][]string {
	var res [][]string
	m := make(map[string][]string)
	for _, str := range strs {
		key := getKey(str)
		m[key] = append(m[key], str)
	}
	for _, v := range m {
		res = append(res, v)
	}
	return res
}

// 用一个大小为26的int数组来统计每个单词中字符出现的次数，
// 然后将int数组转为一个唯一的字符串，跟字符串数组进行映射，
func getKey(s string) string {
	freq := make([]int, 26)
	for _, c := range s {
		freq[c-'a']++
	}
	key := ""
	for _, n := range freq {
		key += strconv.Itoa(n) + "/"
	}
	return key
}
