// https://leetcode-cn.com/problems/group-anagrams/submissions/
package leetcode

func groupAnagrams(strs []string) [][]string {
	table := make(map[[26]byte][]string)
	for _, str := range strs {
		key := getWordKey(str)
		table[key] = append(table[key], str)
	}
	return mapTo2DimensionSlice(table)
}

func mapTo2DimensionSlice(t map[[26]byte][]string) (ret [][]string) {
	for _, v := range t {
		ret = append(ret, v)
	}
	return
}
func getWordKey(str string) (key [26]byte) {
	for _, b := range []byte(str) {
		key[b-'a']++
	}
	return
}
