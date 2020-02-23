//49. 字母异位词分组

package main

import "sort"

type sortRunes []rune

func (s sortRunes) Len() int           { return len(s) }
func (s sortRunes) Less(i, j int) bool { return s[i] < s[j] }
func (s sortRunes) Swap(i, j int)      { s[i], s[j] = s[j], s[i] }

func groupAnagrams(strs []string) [][]string {
	var m = make(map[string][]string)
	for _, str := range strs {
		s := []rune(str)
		sort.Sort(sortRunes(s))
		m[string(s)] = append(m[string(s)], str)
	}
	var n [][]string
	for _, k := range m {
		n = append(n, k)
	}
	return n
}
